package jpabook.jpashop.service;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.item.Book;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemUpdateTest {

    @Autowired
    EntityManager em;

    @Test
    public void updateTest() throws Exception{
        //given
        Book book = em.find(Book.class, 1L);
        //when
        //then
    }
}
