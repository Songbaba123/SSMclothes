<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>消费者页面</title>
<!-- 引入easyui -->
<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css"/>
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css"/>
<script type="text/javascript"  src="easyui/jquery-1.9.1.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
/* 展示所有服装 */
$(function(){
	$("#bt1").click(function(){
		$("#ffsavecol").show();
		var a=$("#iid").html();
    	var b=null;
    	$.getJSON('findbyid_reg.do?iid='+a,function(regt){
    		b=regt.regid;
    		$("#regid").val(b);
    	})
	})
	
	  /* 展示所有服装信息*/
	$("#ffsavecol").hide();
	   $('#showclothes').datagrid({    
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
		      {field:'opt',title:'操作',width:200,align:'center',
		        formatter:function(value,row,index){
				var bt1='<input type="button" value="添加到自己的订单" onclick="dosaveclo('+row.clid+')">';
				//var bt2='<input type="button" value="编辑" onclick="findById('+row.clid+')">';
				//var bt3='<input type="button" value="详细" onclick="findDetail('+row.clid+')">';
				return bt1;
		       }	
		     }   
		   ]]     
		});
	   /* 展示所有服装信息end*/
	   /* 展示当前账号的所有收货信息*/
	   $("#findsavecoll").click(function(){
		   var a=$("#iid").html();
	    	var b=null;
	    	$.getJSON('findbyid_reg.do?iid='+a,function(regt){
	    		b=regt.regid;
	    		$('#showclothes').datagrid({  
	    	    	   url:'findall_coll.do?regid='+b,
	    	    	   striped:true,
	    	 		  singleSelect:true,
	    	 		  fixed:true,
	    	 		  pagination:true,
	    	 		  pageList:[5,10,15,20],
	    	 		  pageSize:5,
	    	 		 columns:[[    
	    			      {field:'coid',title:'编号',width:100,align:'center'},
	    			      {field:'sname',title:'收件人姓名',width:100,align:'center'},
	    			      {field:'phonenumber',title:'收件人手机号',width:100,align:'center'},
	    			      {field:'address',title:'收件地址',width:100,align:'center'},
	    			      {field:'opt',title:'操作',width:200,align:'center',
	    			        formatter:function(value,row,index){
	    					var bt1='<input type="button" value="添加到自己的订单" onclick="dosavecoll('+row.coid+')">';
	    					var bt2='<input type="button" value="编辑" onclick="findById('+row.coid+')">';
	    					var bt3='<input type="button" value="删除" onclick="delbyid('+row.coid+')">';
	    					return bt1+'&nbsp;'+bt2+'&nbsp;'+bt3;
	    			       }	
	    			     }   
	    			   ]]  
	    	       })
	    	})
	    	
       
	})
	/* 展示当前账号的所有收获信息end*/
	
    
    /*该账号所有订单*/

$("#bt2").click(function(){
 var a=$("#iid").html();
	var b=null;
	$.getJSON('findbyid_reg.do?iid='+a,function(regt){
		b=regt.regid;
		alert(b);
$('#showorderall').datagrid({    
    url:'findbyid_ord.do?regid='+b,
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
        {field:'address',title:'收货地址',width:100,align:'center'},
        {field:'opt',title:'操作',width:200,align:'center',
	        formatter:function(value,row,index){
			var bt1='<input type="button" value="删除" onclick="delbyordid('+row.ordid+')">';
			return bt1;
	       }	
	     }   
    ]]     
});  
});  
})

/* 该账号所有订单end */
});	   
	   
       /* 给订单表添值*/    	
function  dosaveclo(clid){
		   $("#fforder").show();
		   $.getJSON('findbyid_clo.do?clid='+clid,function(clothes){
			   $("#clothesname").html(clothes.clothesname);
		   })
		   $("#clid1").val(clid);
		   $('#dg').datagrid('reload');    // 重新载入当前页面数据 
	   }	
	   
	   function  dosavecoll(coid){
		   $("#fforder").show();
		   $.getJSON('findbyid_coll.do?coid='+coid,function(coct){
			  $("#sname").html(coct.sname);
		   })
		   $("#coid1").val(coid);
		   $('#dg').datagrid('reload');    // 重新载入当前页面数据 
	   }
   	/* 给账单表添值end*/
	   	/* 修改收货信息*/
	   	 function findById(coid){
	       alert("找到账号")
	     $("#ffsavecol").show();
		$("#btupdatecol").attr("disabled",false);
		$("#btsavecol").attr("disabled",true);
		$.getJSON('findbyid_coll.do?coid='+coid,function(coct){
			$('#ffsavecol').form('load',{
				'coid':coct.coid,
				'sname':coct.sname,
				'phonenumber':coct.phonenumber,
				'address':coct.address,
				'regid':coct.regid,
			});
		});
		alert("222222222222222");
	}
		 	    	 $(function(){
		 		    	$("#btupdatecol").click(function(){//点击注册按钮
		 		    		$('#ffsavecol').form('submit', {//给表单添加提交
		 		    			url: 'update_coll.do',//调用后台路径
		 		    			success: function(code){
		 		    				if(code=='1'){
		 		    					$.messager.alert('提示','提交成功,返回登录');
		 		    					$('#ffsavecol').hide();//隐藏注册表
		 		    					$('#showcoll').datagrid('reload');    // 重新载入当前页面数据 
		 		    				}else{
		 		    					$.messager.alert('提示','提交失败');  
		 		    					$.messager.alert('111111111111111111',code);
		 		    				}
		 		    			}
		 		    		});
		 		    	}); 
		 		    	})
   	
   	
	   	/* 修改收货信息end*/
	   	/* 删除收货信息*/
	   	 function delbyid(coid){
	     alert("删除账号")
	    $.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
		    if (r){    
		        $.get('delbyid_coll.do?coid='+coid,function(code){
		        	if(code=='1'){
		        		$.messager.alert('提示','删除成功');
						$('#showclothes').datagrid('reload');    // 重新载入当前页面数据  
		        	}else{
		        		$.messager.alert('提示','删除失败');
		        	}
		        });    
		    }    
		});  
}	
	   	/* 删除收货信息end*/
	   	/* 删除订单信息*/
	   	   	 function delbyordid(ordid){
	     alert("删除订单")
	    $.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
		    if (r){    
		        $.get('delbyid_ord.do?ordid='+ordid,function(code){
		        	if(code=='1'){
		        		$.messager.alert('提示','删除成功');
						$('#showorderall').datagrid('reload');    // 重新载入当前页面数据  
		        	}else{
		        		$.messager.alert('提示','删除失败');
		        	}
		        });    
		    }    
		});  
}
	   	
	   	/* 删除订单信息end*/
	   
	   /* 添加收货信息 */
	   $(function(){
	    	$("#btsavecol").click(function(){//点击注册按钮
	    		$('#ffsavecol').form('submit', {//给表单添加提交
	    			url: 'save_coll.do',//调用后台路径
	    			success: function(code){
	    				if(code=='1'){
	    					$.messager.alert('提示','提交成功,返回登录');
	    					$('#ffsavecol').hide();//隐藏注册表
	    				}else{
	    					$.messager.alert('提示','提交失败');  
	    					$.messager.alert('111111111111111111',code);
	    				}
	    			}
	    		});
	    	}); 
	    	})
	    	/* 添加收货信息end*/
	    	
	        /* 添加订单信息*/
	         $(function(){
	    	$("#btsaveord").click(function(){//点击注册按钮
	    		 var a=$("#iid").html();
	 	    	var b=null;
	 	    	$.getJSON('findbyid_reg.do?iid='+a,function(regt){
	 	    		b=regt.regid;
	 	    		$("#regid1").val(b);
	    		alert(b)
	    		$('#fforder').form('submit', {//给表单添加提交
	    			url: 'save_ord.do',//调用后台路径
	    			success: function(code){
	    				if(code=='1'){
	    					$.messager.alert('提示','提交成功,返回登录');
	    					$('#fforder').hide();//隐藏注册表
	    				}else{
	    					$.messager.alert('提示','提交失败');  
	    					$.messager.alert('111111111111111111',code);
	    				}
	    			}
	    		});
	    	}); 
	    	})
	         })
	        /* 添加订单信息end*/
	        
	    	   	  
</script>
</head>
<body>
<div align="center" style="width: 1000;  background-image: url(img/123.jpg)">
        <p>
        <button  name="bt1" id="bt1" >点击添加地址信息</button><br>
        </p>
         <p>
        <button  name="bt2" id="bt2" >查看您的全部订单</button><br>
        </p>
      <table id="showclothes" name="showclothes"  align="center"></table><!-- 展示所有的服装 -->
      <table id="showcoll" name="showcoll" align="center"></table><!-- 展示该账号所有的地址信息 -->
       <table id="showorderall" name="showorderall"  align="center"></table><!-- 展示该账号的所有的订单 -->
<form  method="post" style="padding-top: 100px" name="ffsavecol" id="ffsavecol">
  <table width="350" height="500" >
    <tr>
      <td colspan="2"><div align="center">请先添加您的收货信息</div></td>
    </tr>
    <tr>
      <td >请输入您的姓名：</td>
      <td >
      <input  type="hidden"  id="coid" name="coid">
      <input type="text" name="sname" id="snames"   class="easyui-validatebox" data-options="required:true,missingMessage:'姓名'"/>
      </td>
    </tr>
    <tr>
      <td >请输入您的手机号：</td>
      <td> <input type="text" name="phonenumber" id="phonenumber"  class="easyui-validatebox" data-options="required:true,missingMessage:'手机号'"/>
      </td>
    </tr>
    <tr>
      <td >请输入您的收货地址：</td>
      <td> <input type="text" name="address" id="address"  class="easyui-validatebox" data-options="required:true,missingMessage:'收货地址'"/>
      </td>
    </tr>
     <tr>
     <td colspan="2"><input   type="hidden"  name="regid" id="regid" ></td>
     <td></td>
     </tr>
    <tr>
      <td  colspan="2"><div align="center">
       <input type="button" name="btsavecol" id="btsavecol" value="提交信息"/>
       <input type="button" name="btupdatecol" id="btupdatecol" value="确认修改信息"/>
       <input type="reset" name="rst1" id="rst1" value="重置"/>
      </div></td>
    </tr>    
  </table>
  </form>
  <form  method="post" style="padding-top: 100px" name="fforder" id="fforder">
  <table width="350" height="500" >
    <tr>
      <td colspan="2"><div align="center">订单</div></td>
    </tr>
    <tr>
      <td >您选购的服装是：</td>
      <td ><input type="hidden" name="clid" id="clid1"/><span  id="clothesname"></span>
      </td>
    </tr>
    <tr>
      <td colspan="2"> <input type="hidden" name="regid" id="regid1" />
      </td>
    </tr>
    <tr>
      <td >收货人姓名：</td>
      <td> <input  type="hidden"  id="coid1"  name="coid"><span  id="sname"></span>
      <input  type="button"  id="findsavecoll" name="findsavecoll"  value="点击选择地址信息">
      </td>
    </tr>
    <tr>
      <td  colspan="2"><div align="center">
       <input type="button" name="btsaveord" id="btsaveord" value="提交信息"/>
       <input type="reset" name="rst1" id="rst1" value="重置"/>
      </div></td>
    </tr>    
  </table>
  </form>
  <div id="iid" style="display: none"><%=request.getParameter("iid")%> </div>

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
     <br>
     
      <br>
       <br>
        <br>
         <br>
          <br>
          </div>
</body>
</html>