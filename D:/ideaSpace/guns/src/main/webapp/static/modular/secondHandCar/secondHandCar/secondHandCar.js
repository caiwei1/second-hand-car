/**
 * 二手车管理初始化
 */
var SecondHandCar = {
    id: "SecondHandCarTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
SecondHandCar.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
SecondHandCar.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        SecondHandCar.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加二手车
 */
SecondHandCar.openAddSecondHandCar = function () {
    var index = layer.open({
        type: 2,
        title: '添加二手车',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/secondHandCar/secondHandCar_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看二手车详情
 */
SecondHandCar.openSecondHandCarDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '二手车详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/secondHandCar/secondHandCar_update/' + SecondHandCar.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除二手车
 */
SecondHandCar.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/secondHandCar/delete", function (data) {
            Feng.success("删除成功!");
            SecondHandCar.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("secondHandCarId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询二手车列表
 */
SecondHandCar.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    SecondHandCar.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = SecondHandCar.initColumn();
    var table = new BSTable(SecondHandCar.id, "/secondHandCar/list", defaultColunms);
    table.setPaginationType("client");
    SecondHandCar.table = table.init();
});