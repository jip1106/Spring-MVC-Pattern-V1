package hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/*
    HTTP 응답 메시지는 주로 다음 내용을 담아서 전달한다.
        1. 단순 텍스트 응답
        2. HTML 응답
        3. HTTP API - MessageBody JSON 응답
 */
//3. MessageBody JSON 응답
@WebServlet(name="responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        HelloData helloData = new HelloData();
        helloData.setUsername("jun");
        helloData.setAge(30);

        //{"username":"jun", "age":20}
        //Jackson 라이브러리가 제공하는 objectMapper.writeValueAsString() 를 사용하면
        //객체를 JSON 문자로 변경할 수 있다.
        String result = objectMapper.writeValueAsString(helloData);
        response.getWriter().write(result);


    }
}
