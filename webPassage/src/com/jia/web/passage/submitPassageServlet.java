package com.jia.web.passage;
import com.jia.bean.passage;
import com.jia.service.Service;
import javafx.scene.chart.PieChart;
import javafx.scene.input.DataFormat;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.core.helpers.UUIDUtil;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
public class submitPassageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
         //获取数据进行封装
        passage passage=new passage();
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
                            //商品名称：pname
                            String filename=item.getFieldName();
                            String value;
                            if(filename.equals("type")) {
                                value = item.getString();
                                byte source [] = value.getBytes("iso8859-1");
                                String s=new String(source,"utf-8");
                                passage.setType(s);
                            }
                            if(filename.equals("title")) {
                                value = item.getString();
                                byte source [] = value.getBytes("iso8859-1");
                                String s=new String(source,"utf-8");
                                passage.setTitle(s);

                            }
                            if(filename.equals("authour")) {
                                value = item.getString();
                                byte source [] = value.getBytes("iso8859-1");
                                String s=new String(source,"utf-8");

                                passage.setAuthour(s);
                            }
                            if(filename.equals("context")){
                                value=item.getString();
                                byte source [] = value.getBytes("iso8859-1");
                                String s=new String(source,"utf-8");

                                passage.setContext(s);
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
                            passage.setPicture("upload\\"+reailname);
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
        String uuid=UUIDUtil.getTimeBasedUUID().toString();
        passage.setCid(uuid);
        passage.setState(1);
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy--MM--dd");
        String data=dateFormat.format(new Date());
        passage.setData(data);
        Service service=new Service();
        Boolean flag=service.submitPassage(passage);
        if(flag){
            //提交成功
         response.sendRedirect(request.getContextPath()+"/getPassageList");

        }else{
            //提交失败
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          doPost(request,response);
    }
}
