package com.jia.web.people;

import com.jia.bean.people;
import com.jia.service.Service;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

public class submitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据进行封装
        people people=new people();

        Service service=new Service();
        //创建磁盘文件工厂，
        String tempfile=this.getServletContext().getRealPath("tempfile");
        DiskFileItemFactory factory=new DiskFileItemFactory(1024*1024,new File(tempfile));
        //创建文件核心类
        ServletFileUpload upload=new ServletFileUpload(factory);
        //判断是否为上传文件
        Boolean multipartContext=upload.isMultipartContent(request);
        if(multipartContext){
            upload.setHeaderEncoding("UTF-8");
            try {
                List<FileItem> items=upload.parseRequest(request);
                if(items!=null){
                    for(FileItem item:items){
                        Boolean formFiled=item.isFormField();
                        if(formFiled){
                            String filename=item.getFieldName();
                            String value;
                            if(filename.equals("name")) {
                                value = item.getString();
                                byte source [] = value.getBytes("iso8859-1");
                                String s=new String(source,"utf-8");
                                people.setName(s);
                            }
                            if(filename.equals("type")) {
                                value = item.getString();
                                byte source [] = value.getBytes("iso8859-1");
                                String s=new String(source,"utf-8");
                                Object id=service.getTypeIdByName(s);
                                people.setTypeId(id);
                                people.setType(s);
                            }
                            if(filename.equals("express")){
                                value=item.getString();
                                byte source [] = value.getBytes("iso8859-1");
                                String s=new String(source,"utf-8");
                                people.setExpress(s);
                            }
                            // System.out.println(filename+":"+value);
                        }else{
                            String name=item.getName();
                            String rname[]=name.split("\\\\");
                            String reailname=rname[rname.length-1];
                            System.out.print(reailname);
                            InputStream in=item.getInputStream();
                            String path=this.getServletContext().getRealPath("upload");
                            String realPath=path+"\\"+reailname;
                            OutputStream out=new FileOutputStream(realPath);
                            people.setImg("upload\\"+reailname);
                            System.out.print(realPath);
                            IOUtils.copy(in,out);
                            in.close();
                            out.close();
                        }
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
        }
        Boolean flag=service.submitPeople(people);
        if(flag){
            //提交成功
            response.sendRedirect(request.getContextPath()+"/getPeopleList?typeId="+1);

        }else{
            //提交失败
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPost(request,response);
    }
}
