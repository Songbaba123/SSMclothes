<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
button{
    background-color: transparent;
}
input{
background-color: transparent;
}
</style>
<meta charset="utf-8">
<title>商家页面</title>
<!-- 引入easyui -->
<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css"/>
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css"/>
<script type="text/javascript"  src="easyui/jquery-1.9.1.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">

/*所有服装 */
$(function(){
	
	 $('#dt').hide();
	 $('#ffclo').hide();
	
	$("#savecloth").click(function(){
		 $('#ffclo').show();
		 $('#dg').hide();
		 
	})
	$("#findallorder").click(function(){
		 $('#dt').show();
		 $('#dg').hide();
		 $('#ffclo').hide();
	})
	$("#findallcloth").click(function(){
		$('#dg').show();
		$('#dt').hide();
		$('#ffclo').hide();
	})
	
	$("#findallcloth").click(function(){
	 $('#dg').datagrid({    
		    url:'findall_clo.do',
		    striped:true,
		    singleSelect:true,
		    fixed:true,
		    pagination:true,
		    pageList:[5,10,15,20],
		    pageSize:5,
		    columns:[[    
		        {field:'clid',title:'服装编号',width:100,align:'center'},
		        {field:'clothesname',title:'服装名称',width:100,align:'center'},
		        {field:'photo',title:'服装图片',width:100,align:'center',
		        	formatter:function(value,row,index){
		        		return '<img src=uppic/'+row.photo+' width="60" height="50">';
		        	}
		        },
		        {field:'size',title:'尺码',width:100,align:'center'},
		        {field:'price',title:'价格',width:100,align:'center'},
		        {field:'stock',title:'库存',width:100,align:'center'},
		        {field:'opt',title:'操作',width:200,align:'center',
		        	formatter:function(value,row,index){
						var bt1='<input type="button" value="删除" onclick="dodelById('+row.clid+')">';
						var bt2='<input type="button" value="编辑" onclick="findById('+row.clid+')">';
						//var bt3='<input type="button" value="详细" onclick="findDetail('+row.clid+')">';
						return bt1+'&nbsp;'+bt2;
					}	
		        }   
		    ]]     
		});  
	});  

/* 所有服装end */

/*所有订单*/
$(function(){
	$("#findallorder").click(function(){
		 $('#dg').hide();
	 $('#dt').datagrid({    
		    url:'findall_ord.do',
		    striped:true,
		    singleSelect:true,
		    fixed:true,
		    pagination:true,
		    pageList:[5,10,15,20],
		    pageSize:5,
		  //  $('#ffclo').hide();
		    columns:[[    
		        {field:'ordid',title:'订单编号',width:100,align:'center'},
		        {field:'clothesname',title:'服装名称',width:100,align:'center'},
		        {field:'photo',title:'服装图片',width:100,align:'center',
		        	formatter:function(value,row,index){
		        		return '<img src=uppic/'+row.photo+' width="60" height="50">';
		        	}
		        },
		        {field:'size',title:'尺码',width:100,align:'center'},
		        {field:'price',title:'价格',width:100,align:'center'},
		        {field:'sname',title:'收货人姓名',width:100,align:'center'},
		        {field:'phonenumber',title:'收货手机号',width:100,align:'center'},
		        {field:'address',title:'收货地址',width:100,align:'center'}      
		    ]]     
		});  
	});  
});
/* 所有订单end */

});

/* 删除查找 */
 function dodelById(clid){
	alert("删除账号")
	 $.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
		    if (r){    
		        $.get('delbyid_clo.do?clid='+clid,function(code){
		        	if(code=='1'){
		        		$.messager.alert('提示','删除成功');
						$('#dg').datagrid('reload');    // 重新载入当前页面数据  
		        	}else{
		        		$.messager.alert('提示','删除失败');
		        	}
		        });    
		    }    
		});  
}

 function findById(clid){
	 alert("找到账号")
	 $("#ffclo").show();
		$("#btupdate").attr("disabled",false);
		$("#btsave").attr("disabled",true);
		$.getJSON('findbyid_clo.do?clid='+clid,function(clothes){
			$('#ffclo').form('load',{
				'clid':clothes.clid,
				'clothesname':clothes.clothesname,
				'size':clothes.size,
				'price':clothes.price,
				'stock':clothes.stock,
			});
			  $("#imgg").attr('src','uppic/'+clothes.photo);
		});
		alert("222222222222222");
	}
 /* 保存与修改 */
 $(function(){
 	$("#btsave").click(function(){
 		$("#btupdate").attr("disabled",false);
 		$('#ffclo').form('submit', {
 			url: 'save_clo.do',
 			onSubmit: function(){
 				var isValid = $(this).form('validate');
 				return isValid;	// 返回false终止表单提交
 			},
 			success: function(code){
 				$.messager.alert('提示返回',code);
 				if(code=='1'){
 					$.messager.alert('提示','提交成功');
 					$("#ffclo").form("reset");
 					$('#dg').datagrid('reload');  
 				}else{
 					$.messager.alert('提示','提交失败');  
 					$.messager.alert('111111111111111111');
 				}
 			}
 		});
 	});
 	$("#btupdate").click(function(){
 		alert("tyuio")
 		$('#ffclo').form('submit', {
 			url: 'update_clo.do',
 			onSubmit: function(){
 				var isValid = $(this).form('validate');
 				return isValid;	// 返回false终止表单提交
 			},
 			success: function(code){
 				alert(code);
 				if(code=='1'){
 					$.messager.alert('提示','修改成功');
 					$("#ffclo").form("reset");
 					$("#btsave").attr("disabled",false);//隐藏控件
 					$('#dg').datagrid('reload');    // 重新载入当前页面数据  
 					 $("#ffclo").hide();
 				}else{
 					$.messager.alert('提示','修改失败');  
 				}
 				$.messager.progress('close');	// 如果提交成功则隐藏进度条
 			}
 		});
 	});
 });


 /* 保存与修改end */


</script>
</head>
<body>
<div align="center" style="width: 1000;  background-image: url(img/123.jpg)"> 
    <h1 align="center" style="color: red;">不&ensp;&ensp;要&ensp;&ensp;偷&ensp;&ensp;懒&ensp;&ensp;;&ensp;&ensp;来&ensp;&ensp;数&ensp;&ensp;钱</h1>
      <table id="dg" name="dg"  align="center"></table>
      <table id="dt" name="dt" align="center"></table>
      <div width="350" height="500" style="padding-top:200px">
      <p>
        <button  name="findallcloth" id="findallcloth" >查看所有服装</button><br>
        </p>
        <p>
        <button name="savecloth"  id="savecloth" >添加服装</button><br>
        </p>
        <p>
        <button name="findallorder"  id="findallorder" >查看所有订单</button><br>
        </p>
      </div>
 <form method="post" enctype="multipart/form-data" name="ffclo" id="ffclo">
  <div align="center">
    <table  border="1">
      <tr>
        <td colspan="3"><div align="center">服装添加</div></td>
      </tr>
      <tr>
        <td>服装名称</td>
        <td>
        <input type="hidden" name="clid" id="clid">
        <input type="text" name="clothesname" id="clothesname"></td>
        
        <td width="242" rowspan="5">
        <img id="imgg" alt="图片不存在" src="uppic/default.jpg" width="100%" height="200">
        </td>
      </tr>
      <tr>
        <td>服装照片</td>
        <td>
        <input type="file" name="pic" id="pic"></td>
      </tr>
      <tr>
        <td>尺码</td>
        <td><input type="text" name="size" id="size">
       </td>
      </tr>
      <tr>
        <td>价格</td>
        <td>
        <input type="text" name="price" id="price"></td>
      </tr>
      <tr>
        <td>库存</td>
        <td>
        <input type="text" name="stock" id="stock"></td>
      </tr>
      <tr>
        <td colspan="3"><div align="center">
          <input type="button" name="btsave" id="btsave" value="保存">
          <input type="button" name="btupdate" id="btupdate" value="修改">
          <input type="reset" name="button3" id="button3" value="取消">
        </div></td>
      </tr>
    </table>
  </div>
</form>
     <br>
   <br>
    <br>
     <br>
     
      <br>
       <br>
        <br>
         <br>
          <br>
          <br>
       <br>
        <br>
         <br>
          <br>
          <br>
        <br>
         <br>
          <br>
           <br>
         <br>
          <br>
</div>
</body>
</html>