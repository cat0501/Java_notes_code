package com.itheima.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.User;
import com.itheima.domain.VO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    // 请求地址  http://localhost:8080/user/quick
    //@RequestMapping(value="/quick",method = RequestMethod.GET,params = {"username"})
    @RequestMapping("/quick")
    public String save(){
        System.out.println("Controller save running....");
        return "success";
    }

    @RequestMapping("/quick2")
    public ModelAndView save2(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userName","Lak");
        modelAndView.setViewName("success2");

        return modelAndView;
    }

    /*
    注入的思想
     */
    @RequestMapping("/quick3")
    public ModelAndView save3(ModelAndView modelAndView){
        modelAndView.addObject("userName","0213");
        modelAndView.setViewName("success2");

        return modelAndView;
    }

    @RequestMapping("/quick4")
    public String save4(Model model){
        model.addAttribute("userName","博学谷");
        return "success2";
    }

    @RequestMapping("/quick5")
    public String save5(HttpServletRequest request){
        request.setAttribute("userName","周末");
        return "success2";
    }


    /**
     * 2.回写数据:直接返回字符串
     * @param response
     * @throws IOException
     */
    @RequestMapping("/quick6")
    public void save6(HttpServletResponse response) throws IOException {
        response.getWriter().println("Hello,0213");
    }

    /**
     * 2.回写数据:直接返回字符串
     * 通过@ResponseBody注解告知SpringMVC框架，方法返回的字符串不是跳转是直接在http响应体中返回。
     * @return
     * @throws IOException
     */
    @RequestMapping("/quick7")
    @ResponseBody
    public String save7() throws IOException {
        return "Hello,itheima";
    }

    /**
     * 手动拼接json字符串返回
     * @return
     * @throws IOException
     */
    @RequestMapping("/quick8")
    @ResponseBody
    public String save8() throws IOException {
        return "{\"username\":\"zhangsan\",\"age\":18}";
    }


    /**
     * 开发中往往要将复杂的java对象转换成json格式的字符串，
     * 我们可以使用web阶段学习过的json转换工具jackson进行转换
     * @return
     * @throws IOException
     */
    @RequestMapping("/quick9")
    @ResponseBody
    public String save9() throws IOException {
        User user = new User();
        user.setUsername("lisa");
        user.setPassword("123456");
        // 使用json的转换工具将对象转换成json格式字符串再返回
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        return json;
    }


    /**
     * 通过SpringMVC帮助我们对对象或集合进行json字符串的转换并回写，为处理器适配器配置消息转换参数，
     * 指定使用jackson进行对象或集合的转换，因此需要在spring-mvc.xml中进行如下配置：MappingJackson2HttpMessageConverter
     * @return
     * @throws IOException
     */
    @RequestMapping("/quick10")
    @ResponseBody
    // 期望SpringMVC自动将User转换成json格式的字符串
    public User save10() throws IOException {
        User user = new User();
        user.setUsername("lisa");
        user.setPassword("123456");
        return user;
    }


    /** 5.获得集合类型参数********************************/

    /**
     * 获得集合参数时，要将集合参数包装到一个POJO中才可以。
     * @param vo
     * @throws IOException
     */
    @RequestMapping("/quick14")
    @ResponseBody
    public void save14(VO vo) throws IOException {
        System.out.println(vo);
    }

    /**
     * 当使用ajax提交时，可以指定contentType为json形式，那么在方法参数位置使用@RequestBody可以直接接收集合数据而无需使用POJO进行包装。
     * @param userList
     * @throws IOException
     */
    @RequestMapping("/quick15")
    @ResponseBody
    public void save15(@RequestBody List<User> userList) throws IOException {
        System.out.println(userList);
    }


    /**
     * 当请求的参数名称与Controller的业务方法参数名称不一致时，就需要通过@RequestParam注解显示的绑定。
     * @param userName
     * @throws IOException
     */
    @RequestMapping("/quick16")
    @ResponseBody
    public void save16(@RequestParam(value = "name",
            required = false, defaultValue = "ak") String userName) throws IOException {
        System.out.println(userName);
    }

    /**
     * 自定义类型转换器
     * @param data
     * @throws IOException
     */
    @RequestMapping("/quick18")
    @ResponseBody
    public void save18(Date data) throws IOException {
        System.out.println(data);
    }


    /**
     * SpringMVC支持使用原始ServletAPI对象作为控制器方法的参数进行注入
     * @param request
     * @param response
     * @param session
     * @throws IOException
     */
    @RequestMapping("/quick19")
    @ResponseBody
    public void save19(HttpServletRequest request, HttpServletResponse response,
                       HttpSession session) throws IOException {
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
    }

    /**
     * @RequestHeader 获得请求头
     * @param User_Agent
     * @throws IOException
     */
    @RequestMapping("/quick20")
    @ResponseBody
    public void save20(@RequestHeader(value = "User-Agent")String User_Agent) throws IOException {
        System.out.println(User_Agent);
    }

    /**
     * 使用@CookieValue可以获得指定Cookie的值
     * @param jessionId
     * @throws IOException
     */
    @RequestMapping("/quick21")
    @ResponseBody
    public void save21(@CookieValue(value = "JSESSIONID")String jessionId) throws IOException {
        System.out.println(jessionId);
    }


    /**
     * 单个文件上传
     * @param username
     * @param uploadFile
     * @throws IOException
     */
    @RequestMapping("/quick22")
    @ResponseBody
    public void save22(String username, MultipartFile uploadFile) throws IOException {
        System.out.println(username);
        // 获得上传文件的名称
        String filename = uploadFile.getOriginalFilename();
        uploadFile.transferTo(new File("/Users/cat/upload/" + filename));
    }

    /**
     * 多文件上传
     * @param username
     * @param uploadFiles
     * @throws IOException
     */
    @RequestMapping("/quick23")
    @ResponseBody
    public void save23(String username, MultipartFile[] uploadFiles) throws IOException {
        System.out.println(username);

        for (MultipartFile uploadFile : uploadFiles) {
            // 获得上传文件的名称
            String filename = uploadFile.getOriginalFilename();
            uploadFile.transferTo(new File("/Users/cat/upload/" + filename));
        }
    }


}
