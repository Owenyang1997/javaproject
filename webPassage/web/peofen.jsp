<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
</head>
<div>
    <th width="120"><i class="require-red"></i>选择分类</th>
    <td>
        <select name="type" id="catid" class="required">
        </select>
    </td>
    <script type="text/javascript">
        $(function(){
            $.ajax({
                url:"${pageContext.request.contextPath}/getPeopleType",
                success:function(data){
                    var category=" <option value=\"\">请选择</option>";
                    for(var i=0;i<data.length;i++){
                        category+="<option value='"+data[i].type+"'>"+data[i].type+"</option>";
                    }
                    $("#catid").html(category);
                },
                dataType: "json"
            });
        });
    </script>
</div>

