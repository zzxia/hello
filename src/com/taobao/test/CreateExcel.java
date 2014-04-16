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
 * Time: ����6:58
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
        String data[][]={{"���˻�"��"lixinghua","30��"},{"����","zhangsan","23��"}};
        //��������ļ�·��
        File outFile=new File("test.xls");
        //��������ļ�����ͨ��workbook�����
        WritableWorkbook workbook= Workbook.createWorkbook(outFile);
        //����һ�������������ֻ��һ��sheet,������������Ϊ0
        WritableSheet sheet=workbook.createSheet("test"��0);
        Label lab=null;           //�������ǩ
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