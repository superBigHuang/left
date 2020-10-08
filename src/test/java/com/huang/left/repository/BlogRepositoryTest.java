package com.huang.left.repository;

import com.huang.left.entity.Blog;
import com.huang.left.entity.User;
import org.aspectj.weaver.ast.Var;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import sun.text.normalizer.UBiDiProps;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class BlogRepositoryTest {

    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private UserRepository userRepository;


    @Test
    public void find1() {
        Optional<User> byId = userRepository.findById(2L);
        System.out.println("byId = " + byId.isPresent());
        User user = byId.get();
        System.out.println("user = " + user);


        List<Blog> byUserWatch = blogRepository.findByUser_Fans(user, PageRequest.of(1,1));
        for (Blog userWatch : byUserWatch) {
            System.out.println("userWatch = " + userWatch);
        }
    }

    @Test
    public void find2() {
        List<Blog> byUser_id = blogRepository.findByUser_Id(1L, PageRequest.of(0, 5));
        for (Blog blog : byUser_id) {
            System.out.println("blog = " + blog);
        }
    }

    @Test
    public void find3() {
        List<Blog> byUser_id = blogRepository.findByContent("1");
        for (Blog blog : byUser_id) {
            System.out.println("blog = " + blog);
        }
    }

    @Test
    public void find4() {
        Page<Blog> all = blogRepository.findAll(PageRequest.of(0, 4));
        Iterator<Blog> iterator = all.iterator();
        for (Blog blog : all) {
            System.out.println("blog = " + blog);
        }
        int numberOfElements = all.getNumberOfElements();
        System.out.println("numberOfElements = " + numberOfElements);
        List<Blog> content = all.getContent();
        for (Blog blog : content) {
            System.out.println("blog2 = " + blog);
        }
    }

    @Test
    public void testSplit() {
        String s = "https://i.picsum.photos/id/10/2500/1667.jpg?hmac=J04WWC_ebchx3WwzbM-Z4_KC_LeLBWr5LZMaAkWkF68;https://i.picsum.photos/id/1003/1181/1772.jpg?hmac=oN9fHMXiqe9Zq2RM6XT-RVZkojgPnECWwyEF1RvvTZk;https://i.picsum.photos/id/1004/5616/3744.jpg?hmac=Or7EJnz-ky5bsKa9_frdDcDCR9VhCP8kMnbZV6-WOrY";
        String[] split = s != null ? s.split(";") : null;
        for (String s1 : split) {
            System.out.println("s1 = " + s1);
        }
    }



}