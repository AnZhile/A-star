package com.atyuanchuang;

import com.atyuanchuang.award.srevice.AwardService;
import com.atyuanchuang.contest.service.ContestService;
import com.atyuanchuang.member.mapper.GroupMapper;
import com.atyuanchuang.member.mapper.SelfMapper;
import com.atyuanchuang.member.service.GroupSelfService;
import com.atyuanchuang.member.service.GroupService;
import com.atyuanchuang.member.service.impl.GroupServiceImpl;
import com.atyuanchuang.model.awardDAO.Award;
import com.atyuanchuang.model.memberDAO.User;
import com.atyuanchuang.member.service.impl.SelfServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.AfterTestClass;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anzhi
 * @data 2023/7/29 - 14:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentMapperTest {
    @Autowired
    private GroupService groupService;

    @Autowired
    private AwardService awardService;

    @Autowired
    private GroupSelfService groupSelfService;

    @Autowired
    private ContestService contestService;

    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    private SelfMapper selfMapper;


    @Test
    public void testSelectList() {
        groupService.getAllGroupSelf();
    }
    @Test
    public void test1() {
        groupService.getGroupBySelfId(43L);
    }

    @Test
    public void test2() {
        contestService.list();
    }

    @Test
    public void test() {
        awardService.getAwardById(36L);
    }

    @Test
    public void test3() {
        List<String> strings = new ArrayList<>();
        strings.add("qq");
        strings.add("xx");
        strings.add("3");
        selfMapper.check(strings);
        System.out.println("groupMapper.check(strings) = " + selfMapper.check(strings));
    }

    @Test
    public void test4() {
        Award award = new Award();
        award.setGroupName("5");
        award.setUserName("r");
        groupMapper.checkGroup(award);
        System.out.println("groupMapper.check(award) = " + groupMapper.checkGroup(award).size());

    }

    @Test
    public void test5() {
        awardService.getAwardById(75L);
    }

}
