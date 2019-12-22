$(function () {
    $("#jqGrid").jqGrid({
        url: '/admin/userapply/list1',
        datatype: "json",
        colModel: [
            {label: 'id', name: 'applyUserID', index: 'applyUserID', width: 50, key: true, hidden: true},
            {label: '申请成为商家', name: 'applyFlag', index: 'applyFlag', width: 60, formatter: modifyApplyFormatter},
            {label: '申请理由', name: 'applyReason', index: 'applyReason', width: 120},
            {label: '申请时间', name: 'applyTime', index: 'applyTime', width: 100},
            {label: '是否注销', name: 'applyIsDeleted', index: 'applyIsDeleted', width: 60, formatter: deletedFormatter}
        ],
        height: 560,
        rowNum: 10,
        rowList: [10, 20, 50],
        styleUI: 'Bootstrap',
        loadtext: '信息读取中...',
        rownumbers: false,
        rownumWidth: 20,
        autowidth: true,
        multiselect: true,
        pager: "#jqGridPager",

        //排序
        // loadonce:false,
        // sortable: true,
        // sortname: 'rightFlag', //设置默认的排序列
        // sortorder: 'asc',

        jsonReader: {
            root: "data.list",
            page: "data.currPage",
            total: "data.totalPage",
            records: "data.totalCount"
        },
        prmNames: {
            page: "page",
            rows: "limit",
            order: "order",
        },
        gridComplete: function () {
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        }
    });

    $(window).resize(function () {
        $("#jqGrid").setGridWidth($(".card-body").width());
    });

    // function lockedFormatter(cellvalue) {
    //     if (cellvalue == 0) {
    //         return "<button type=\"button\" class=\"btn btn-block btn-success btn-sm\" style=\"width: 50%;\">正常</button>";
    //     } else if (cellvalue == 1) {
    //         return "<button type=\"button\" class=\"btn btn-block btn-secondary btn-sm\" style=\"width: 50%;\">锁定</button>";
    //     }
    //     else if (cellvalue == 2) {
    //         return "<button type=\"button\" class=\"btn btn-block btn-info btn-sm\" style=\"width: 50%;\">商家</button>";
    //     }
    // }

    function modifyApplyFormatter(cellvalue) {
        if (cellvalue == 0) {
            return "<button type=\"button\" class=\"btn btn-block btn-success btn-sm\" style=\"width: 50%;\">申请商家</button>";
        } else if (cellvalue == 1) {
            return "<button type=\"button\" class=\"btn btn-block btn-info btn-sm\" style=\"width: 50%;\">通过申请</button>";
        } else if (cellvalue == 2) {
            return "<button type=\"button\" class=\"btn btn-block btn-danger btn-sm\" style=\"width: 50%;\">拒绝申请</button>";
        }
    }

    function deletedFormatter(cellvalue) {
        if (cellvalue == 0) {
            return "<button type=\"button\" class=\"btn btn-block btn-success btn-sm\" style=\"width: 50%;\">正常</button>";
        } else if (cellvalue >= 1) {
            return "<button type=\"button\" class=\"btn btn-block btn-secondary btn-sm\" style=\"width: 50%;\">注销</button>";
        }
    }
});

/**
 * jqGrid重新加载
 */
function reload() {
    var page = $("#jqGrid").jqGrid('getGridParam', 'page');
    $("#jqGrid").jqGrid('setGridParam', {
        page: page
    }).trigger("reloadGrid");
}


// function lockUser(lockStatus) {
//     var ids = getSelectedRows();
//     if (ids == null) {
//         return;
//     }
//     if (lockStatus != 0 && lockStatus != 1 && lockStatus != 2) {
//         swal('非法操作', {
//             icon: "error",
//         });
//     }
//     swal({
//         title: "确认弹框",
//         text: "确认要修改账号状态吗?",
//         icon: "warning",
//         buttons: true,
//         dangerMode: true,
//     }).then((flag) => {
//             if (flag) {
//                 $.ajax({
//                     type: "POST",
//                     url: "/admin/users/lock/" + lockStatus,
//                     contentType: "application/json",
//                     data: JSON.stringify(ids),
//                     success: function (r) {
//                         if (r.resultCode == 200) {
//                             swal("操作成功", {
//                                 icon: "success",
//                             });
//                             $("#jqGrid").trigger("reloadGrid");
//                         } else {
//                             swal(r.message, {
//                                 icon: "error",
//                             });
//                         }
//                     }
//                 });
//             }
//         }
//     )
//     ;
// }

function modifyApplyUser(applyStatus) {
    var ids = getSelectedRows();
    if (ids == null) {
        return;
    }
    if (applyStatus != 0 && applyStatus != 1) {
        swal('非法操作', {
            icon: "error",
        });
    }
    swal({
        title: "确认弹框",
        text: "确认要修改账号权限吗?",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    }).then((flag) => {
        if (flag) {
            $.ajax({
                type: "POST",
                url: "/admin/userapply/modifyApply/" + applyStatus,
                contentType: "application/json",
                data: JSON.stringify(ids),
                success: function (r) {
                    if (r.resultCode == 200) {
                        swal("操作成功", {
                            icon: "success",
                        });
                        $("#jqGrid").trigger("reloadGrid");
                    } else {
                        swal(r.message, {
                            icon: "error",
                        });
                    }
                }
            });
        }
    }
)
    ;
}