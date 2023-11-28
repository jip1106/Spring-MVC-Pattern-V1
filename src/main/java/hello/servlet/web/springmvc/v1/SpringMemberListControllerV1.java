package hello.servlet.web.springmvc.v1;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
@Controller
public class SpringMemberListControllerV1{

    private MemberRepository memberRepository = MemberRepository.getInstance();
    @RequestMapping("/springmvc/v1/members")
    public ModelAndView process() {
        List<Member> memberList = memberRepository.findAll();
        ModelAndView mv = new ModelAndView("members");

        mv.getModel().put("members", memberList);
        mv.addObject("members",memberList);

        return mv;
    }
}
