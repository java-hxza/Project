$(document).ready(function () {
    excel = new ExcelGen({
        "src_id": "ChargePeriod",
        "show_header": true
    });
    $(".sb").click(function () {
        excel.generate();
    });
});
//$("#ChargePeriod").tableExport({
//	exportTypes:["txt"],
//	fileName : "课时收费单-" + $(".customCheckes:checked").parent().parent().next().next().next().text(),
//	bootstrap : false
//});