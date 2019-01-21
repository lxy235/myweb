package com.myweb.servlets;


import com.myweb.utils.Util;
import com.myweb.views.View;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "BaseServlet")
public class BaseServlet extends HttpServlet {
    /**
     * 视图对象
     */
    protected View view = null;

    protected HttpServletRequest _request = null;
    protected HttpServletResponse _response = null;

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) {
        view = new View(req, resp);
        _request = req;
        _response = resp;
        _service(req, resp);
    }

    /**
     * 业务逻辑，子类覆盖这个方法
     *
     * @param req
     * @param resp
     */
    public void _service(HttpServletRequest req, HttpServletResponse resp) { }

    /**
     * 快捷输出
     *
     * @param value
     */
    protected void dd(Object value) {
        System.out.println(value);
    }

    /**
     * 成功，json格式
     * @param msg
     * @param data
     */
    protected void toSuccess(String msg, HashMap<String, Object> data) {
        _response.setContentType("application/json");
        try {
            _response.getWriter().write(Util.toSuccess(msg, data));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 成功，json格式
     * @param msg
     */
    protected void toSuccess(String msg) {
        _response.setContentType("application/json");
        HashMap<String, Object> data = new HashMap<String, Object>();
        try {
            _response.getWriter().write(Util.toSuccess(msg, data));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 输出错误，json格式
     * @param msg
     * @param data
     */
    protected void toFail(String msg, HashMap<String, Object> data) {
        _response.setContentType("application/json");
        try {
            _response.getWriter().write(Util.toFail(msg, data));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 输出错误，json格式
     * @param msg
     */
    protected void toFail(String msg) {
        _response.setContentType("application/json");
        HashMap<String, Object> data = new HashMap<String, Object>();
        try {
            _response.getWriter().write(Util.toFail(msg, data));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
