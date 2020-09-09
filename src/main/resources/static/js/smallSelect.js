var s = function (index) {
    var s_department = function () {
        $.ajax({
            cache: false,
            type: "POST",
            url: "/select/department/getAll",
            data: {},
            dataType: "json",
            success: function (data) {
                if (data.code == 1) {
                    var list = [];
                    list = list.concat(data.data);
                    $("#departmentId"+index).empty();
                    $("#departmentId"+index).append("<option value=''>--请选择院系--</option>");
                    if (list.length > 0) {
                        for (var i = 0; i < list.length; i++) {
                            var option = "<option value='" + list[i].id + "'>" + list[i].name + "</option>";
                            $("#departmentId"+index).append(option);
                        }
                    }
                }
            }
        });
    }


    var s_major = function () {
        $.ajax({
            cache: false,
            type: "POST",
            url: "/select/major/" + $("#departmentId"+index).val(),
            data: {},
            dataType: "json",
            success: function (data) {
                if (data.code == 1) {
                    var list = [];
                    list = list.concat(data.data);
                    $("#majorId"+index).empty();
                    $("#majorId"+index).append("<option value=''>--请选择专业--</option>");
                    if (list.length > 0) {
                        for (var i = 0; i < list.length; i++) {
                            var option = "<option value='" + list[i].id + "'>" + list[i].name + "</option>";
                            $("#majorId"+index).append(option);
                        }
                    }
                }
            }
        });
    }


    var s_clazz = function () {

        $.ajax({
            cache: false,
            type: "GET",
            url: "/select/clazz?departmentId=" + $("#departmentId"+index).val() + "&majorId=" + $("#majorId"+index).val(),
            data: {},
            dataType: "json",
            success: function (data) {
                if (data.code == 1) {
                    var list = [];
                    list = list.concat(data.data);
                    $("#clazzId"+index).empty();
                    $("#clazzId"+index).append("<option value=''>--请选择班级--</option>");
                    if (list.length > 0) {
                        for (var i = 0; i < list.length; i++) {
                            var option = "<option value='" + list[i].id + "'>" + list[i].name + "</option>";
                            $("#clazzId"+index).append(option);
                        }
                    }
                }
            }
        });
    }


    $("#departmentId"+index).change(function () {
        $("#majorId"+index).empty();
        $("#majorId"+index).append("<option value=''>--请选择专业--</option>");

        $("#clazzId"+index).empty();
        $("#clazzId"+index).append("<option value=''>--请选择班级--</option>");
        s_major();

    })


    $("#majorId"+index).change(function () {
        $("#clazzId"+index).empty();
        $("#clazzId"+index).append("<option value=''>--请选择班级--</option>");
        s_clazz();
    })
    
    s_department();
}

