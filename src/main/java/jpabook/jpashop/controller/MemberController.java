package jpabook.jpashop.controller;

import jakarta.validation.Valid;
import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members/new") // 회원 등록 페이지로 이동
    public String createForm(Model model){
        model.addAttribute("memberForm",new MemberForm());
        // 빈껍데기라도 validation을 해주기에 가져간다.

        return "members/createMemberForm";
    }

    @PostMapping("/members/new") // 회원 등록
    public String create(@Valid MemberForm memberForm, BindingResult result){

        if (result.hasErrors()){
            return "members/createMemberForm";
        }

        Address address = new Address(memberForm.getCity(), memberForm.getStreet(), memberForm.getZipcode());

        Member member = new Member();
        member.setName(memberForm.getName());
        member.setAddress(address);

        try {
            memberService.join(member);
        } catch (IllegalStateException e) {
            result.rejectValue("name", "400", e.getMessage());
            return "members/createMemberForm";
        }

        return "redirect:/";
    }

    @GetMapping("/members") // 회원 목록 조회
    public String list(Model model){
        model.addAttribute("members",memberService.findMembers());
        return "members/memberList";
    }

}
