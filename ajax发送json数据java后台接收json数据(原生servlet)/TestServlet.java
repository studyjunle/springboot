package test;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        // 方式1
        // 获取json数据
        /*JSONObject json = json1(req);
        // 返回到前端
        PrintWriter out = resp.getWriter();
        out.print(json);*/

        // 方式2
        // 获取json数据
        JSONObject jsonObject = json2(req);
        // 返回到前端
        PrintWriter out = resp.getWriter();
        out.print(jsonObject);

    }

    /**
     * 接收json数据方式1：
     *      请求头 content-Type: application/json
     *      返回json对象
     *
     *      推荐使用
     * @param request
     * @return
     */
    private JSONObject json1(HttpServletRequest request) {
        JSONObject json= new JSONObject();
        BufferedReader br;
        try {
            br = new BufferedReader(new InputStreamReader((ServletInputStream) request.getInputStream()));
            String line = null;
            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
            json= JSONObject.parseObject(sb.toString());
            return json;
        } catch (IOException e) {
            e.printStackTrace();
            return json;
        }
    }

    /**
     * 接收json数据方式2：
     *      请求头 content-Type: application/x-www-form-urlencoded
     *      返回json对象
     * @param request
     * @return
     */
    private JSONObject json2(HttpServletRequest request) {
        String reportInfo = request.getParameter("reportInfo");
        return JSONObject.parseObject(reportInfo);
    }
}
