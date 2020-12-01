var department = function () {
    $("#departmentId").append("<option value=''>--请选择学院--</option>");
    $.ajax({
        async: false,
        cache: false,
        type: "POST",
        url: "/select/department/getAll",
        data: {},
        dataType: "json",
        success: function (data) {
            if (data.code == 1) {
                var list = [];
                list = list.concat(data.data);
                $("#departmentId").empty();
                $("#departmentId").append("<option value=''>--请选择学院--</option>");
                if (list.length > 0) {
                    for (var i = 0; i < list.length; i++) {
                        var option = "<option value='" + list[i].id + "'>" + list[i].name + "</option>";
                        $("#departmentId").append(option);
                    }
                }
            }
        }
    });
}


var major = function () {
    $.ajax({
        cache: false,
        type: "POST",
        url: "/select/major/" + $("#departmentId").val(),
        data: {},
        dataType: "json",
        success: function (data) {
            if (data.code == 1) {
                var list = [];
                list = list.concat(data.data);
                $("#majorId").empty();
                $("#majorId").append("<option value=''>--请选择专业--</option>");
                if (list.length > 0) {
                    for (var i = 0; i < list.length; i++) {
                        var option = "<option value='" + list[i].id + "'>" + list[i].name + "</option>";
                        $("#majorId").append(option);
                    }
                }
            }
        }
    });
}


var grade = function () {
    let date = new Date()
    let year = date.getFullYear()
    $("#grade").append("<option value=''>--请选择年级--</option>");
    $("#grade").append("<option value='" + year + "'>" + year + "级</option>");
    $("#grade").append("<option value='" + (year - 1) + "'>" + (year - 1) + "级</option>");
    $("#grade").append("<option value='" + (year - 2) + "'>" + (year - 2) + "级</option>");
    $("#grade").append("<option value='" + (year - 3) + "'>" + (year - 3) + "级</option>");
}


var clazz = function () {

    $.ajax({
        cache: false,
        type: "GET",
        url: "/select/clazz?departmentId=" + $("#departmentId").val() + "&grade=" + $("#grade").val() + "&majorId=" + $("#majorId").val(),
        data: {},
        dataType: "json",
        success: function (data) {
            if (data.code == 1) {
                var list = [];
                list = list.concat(data.data);
                $("#clazzId").empty();
                $("#clazzId").append("<option value=''>--请选择班级--</option>");
                if (list.length > 0) {
                    for (var i = 0; i < list.length; i++) {
                        var option = "<option value='" + list[i].id + "'>" + list[i].name + "</option>";
                        $("#clazzId").append(option);
                    }
                }
            }
        }
    });
}


$("#departmentId").change(function () {
    //console.log("--监听--")

    $("#majorId").empty();
    $("#majorId").append("<option value=''>--请选择专业--</option>");

    $("#clazzId").empty();
    $("#clazzId").append("<option value=''>--请选择班级--</option>");
    major();
    reLoad()
})


$("#majorId").change(function () {
    $("#clazzId").empty();
    $("#clazzId").append("<option value=''>--请选择班级--</option>");

    clazz();
    reLoad();
})


$("#grade").change(function () {
    $("#clazzId").empty();
    $("#clazzId").append("<option value=''>--请选择班级--</option>");
    clazz();
    reLoad();
})

$("#clazzId").change(function () {
    reLoad()
})

