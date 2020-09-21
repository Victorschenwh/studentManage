function Utils() {
    this.get = function (url) {
        let obj = {};
        $.ajax({
            //cache: true,
            async: false,
            type: "POST",
            url: url,
            dataType: "json",
            data: {},
            success: function (res) {
                if (res.code == 1) {
                    obj = res.data;
                }
            }
        });
        return obj;
    }
}

