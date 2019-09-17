$(function() {
	print = function() {
		$("#tables").show();
		bdhtml = $(".table-responsive").html();
		//alert(bdhtml);
		sprnstr = "<!--startprint-->"; //开始打印标识字符串有17个字符
		eprnstr = "<!--endprint-->"; //结束打印标识字符串
		prnhtml = bdhtml.substr(bdhtml.indexOf(sprnstr) + 17); //从开始打印标识之后的内容
		prnhtml = prnhtml.substring(0, prnhtml.indexOf(eprnstr)); //截取开始标识和结束标识之间的内容
		var iframe = null;
		iframe = document.getElementById("iframe1")

		var iwindow = null;
		var iwindow = iframe.contentWindow; //获取iframe的window对象
		iwindow.document.close();
		iwindow.document.write(prnhtml);
		iwindow.print(); //调用浏览器的打印功能打印指定区域
	}

	exportExsal = function() {
		excel = new ExcelGen({
			"src_id" : "products-datatable",
			"show_header" : true
		});
		excel.generate();
	}
});