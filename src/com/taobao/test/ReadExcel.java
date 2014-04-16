package com.taobao.test;

import jxl.Sheet;
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

public class ReadExcel extends HttpServlet {
    public void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException {
        this.doPost(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException {
        //request.setCharacterEncoding("BGK");
        //response.setContentType("text/html");

        //定义输出文件路径
        File inFile=new File("test.xls");
        //建立输出文件对象，通过workbook类完成
        WritableWorkbook workbook= Workbook.createWorkbook(inFile);
        //建立一个表格区，由于只有一个sheet,所以索引设置为0
        Sheet sheet[]=workbook.getSheets();                //到得excel文件
        for (int x=0;x<data.length;x++){                   //输出全部到sheet
            for(int y=0;y<sheet[x].getRows();y++){         //取得全部的行数
                for(int z=0;z<sheet[x].getColumns();z++){  //取得全部的列数
                    String content=sheet[x].getCell(z,y).getContents();//取得内容
                    System.out.print(content+"\t\t");
                }
                System.out.println();      //换行
            }
        }
        workbook.write();
        Workbook.close();
    }
}