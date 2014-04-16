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
 * Time: ����6:58
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

        //��������ļ�·��
        File inFile=new File("test.xls");
        //��������ļ�����ͨ��workbook�����
        WritableWorkbook workbook= Workbook.createWorkbook(inFile);
        //����һ�������������ֻ��һ��sheet,������������Ϊ0
        Sheet sheet[]=workbook.getSheets();                //����excel�ļ�
        for (int x=0;x<data.length;x++){                   //���ȫ����sheet
            for(int y=0;y<sheet[x].getRows();y++){         //ȡ��ȫ��������
                for(int z=0;z<sheet[x].getColumns();z++){  //ȡ��ȫ��������
                    String content=sheet[x].getCell(z,y).getContents();//ȡ������
                    System.out.print(content+"\t\t");
                }
                System.out.println();      //����
            }
        }
        workbook.write();
        Workbook.close();
    }
}