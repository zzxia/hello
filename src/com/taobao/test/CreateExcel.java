package com.taobao.test;

import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: hegen
 * Date: 14-4-16
 * Time: 下午6:58
 * To change this template use File | Settings | File Templates.
 */

public class CreateExcel extends HttpServlet {
    public void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException {
        this.doPost(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException {
        //request.setCharacterEncoding("BGK");
        //response.setContentType("text/html");
        String data[][]={{"李兴华"，"lixinghua","30岁"},{"张三","zhangsan","23岁"}};
        //定义输出文件路径
        File outFile=new File("test.xls");
        //建立输出文件对象，通过workbook类完成
        WritableWorkbook workbook= Workbook.createWorkbook(outFile);
        //建立一个表格区，由于只有一个sheet,所以索引设置为0
        WritableSheet sheet=workbook.createSheet("test"，0);
        Label lab=null;           //定义表格标签
        for (int x=0;x<data.length;x++){
            for(int y=0;y<data[x].length;y++){
                lab=new Label(y,x,data[x][y]);
                sheet.addCell(lab);
            }
        }
        workbook.write();
        Workbook.close();
    }
}