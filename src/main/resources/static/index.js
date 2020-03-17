const serverErrorPage = "error500.html";

$(".wrapper").ready(function () {
    $.get("/start",
        {
            "command": "ALL_DATA"
        }, request).fail(function () {
        window.location.href = serverErrorPage;
    });

    function request(response) {
        let eTable = "";
        $.each(response, function (index, value) {
            eTable += "<tr id=" + JSON.parse(value)[0].messageId + ">" + "<th>" + "<ul>";
            $.each(JSON.parse(value), function (index, iValue) {
                eTable += "<li value=\"" + iValue.id + "\">" + iValue.name + "";
            });
            eTable += "</th>" + "<th>" + "<li>" + index + "</li>";
            eTable += "</ul>" + "</th>";
            eTable += "<th>"+ "<button type=\"button\" class=\"btnAddCity\"><a href=\"#openModalAddCity\">Add City</a></button>"+ "</th>" +
                "<th>"+ "<button type=\"button\" class=\"btnUpdateMessage\"><a href=\"#openModalUpdateMessage\">Update message</a></button>"  + "</th>" +
            "<th>" + "<button type=\"button\" class=\"btnDeleteCities\"><a href=\"#openModalDeleteCities\">Delete cities</a></button>" + "</th>" +
            "<th>" + "<button type=\"button\" class=\"btnDelete\"><a href=\"#openModalDelete\">Delete</a></button>";
            eTable += "</th>" +"</tr>";
        });
        $(".wrapper").html(eTable);
    }
});

$(".confirmNewData").click(function () {
    const city = $("#newCityNewData").val();
    const cities = [];
    cities.push(city);

    const message = $("#newMessageNewData").val();
    const newData = { message : message, cities : cities};
    $.post("/start",
        {
            command : "ADD_DATA",
            data : JSON.stringify(newData)
        }, request).fail(function () {
        window.location.href = serverErrorPage;
    });

    function request(response) {
        if (response.warn) {
            alert(response.warn);
        } else {
            alert(response.success);
            window.location.reload();
        }
    }
});

$(".wrapper").on("click", ".btnAddCity", function () {
    let i = $(this).closest("tr").attr("id");
    $(".confirmNewCity").val(i);
});

$(".confirmNewCity").click(function () {
    const newCity = {id : null, name : $("#newCityAddCity").val(), messageId : $(".confirmNewCity").val()};
    $.post("/start",
        {
            command: "ADD_CITY",
            data: JSON.stringify(newCity)
        }, request).fail(function () {
        window.location.href = serverErrorPage;
    });

        function request(response) {
            if (response.warn) {
                alert(response.warn);
            } else {
                alert(response.success);
                window.location.reload();
            }
        }
});

$(".wrapper").on("click", ".btnUpdateMessage", function () {
    let i = $(this).closest("tr").attr("id");
    const message = $(this).closest("tr").children(0).children(0)[1].firstChild.wholeText;
    $(".confirmUpdateMessage").val(i);
    $("#updateMessage").val(message);
});

$(".confirmUpdateMessage").click(function () {
    const updateMessage = {id : $(".confirmUpdateMessage").val(), message : $("#updateMessage").val()};
    $.post("/start",
        {
            command: "UPDATE_MESSAGE",
            data: JSON.stringify(updateMessage)
        }, request).fail(function () {
        window.location.href = serverErrorPage;
    });

    function request(response) {
        if (response.warn) {
            alert(response.warn);
        } else {
            alert(response.success);
            window.location.reload();
        }
    }
});

$(".wrapper").on("click", ".btnDeleteCities", function () {
    let i = $(this).closest("tr").attr("id");
    $(".confirmDeleteCities").val(i);
    const cities = $(this).closest("tr").children(0).children(0)[0].children;
    let eTable = "";
    $.each(cities, function (index, value) {
        eTable += "<li> <input type=\"checkbox\" value=\""
            + value.value + "\" name=\"" + value.firstChild.wholeText + "\">" + value.firstChild.wholeText + "</li>";
    });
    $(".deleteCitiesUL").html(eTable);

    // $.post("/start",
    //     {
    //         command : "REMOVE_CITY",
    //         new : JSON.stringify(cities)
    //     }, request).fail(function () {
    //     window.location.href = serverErrorPage;
    // });
    //
    // function request(response) {
    //     if (response.exist) {
    //         alert(response.exist);
    //     } else {
    //         alert(response.success);
    //     }
    // }
});

$(".confirmDeleteCities").click(function () {
    const elements = $(".deleteCitiesUL")[0].getElementsByTagName("input");
    const cities = [];
    $.each(elements, function (index, value) {
        if (value.checked) {
            cities.push({id : value.value, name : value.name, messageId : $(".confirmDeleteCities").val()});
        }
    });

    $.post("/start",
        {
            command: "REMOVE_CITY",
            data: JSON.stringify(cities)
        }, request).fail(function () {
        window.location.href = serverErrorPage;
    });

    function request(response) {
        if (response.warn) {
            alert(response.warn);
        } else {
            alert(response.success);
            window.location.reload();
        }
    }
});

$(".wrapper").on("click", ".btnDelete", function () {
    let i = $(this).closest("tr").attr("id");
    $(".confirmDelete").val(i);

    const message = "В Нью-Йорке можно посетить следующие места: Статуя Свободы, Таймс Сквер и Небоскреб Эмпайр-стейт-Билдинг.";
    const messageId = 6;

    const deleteMessage = {id : messageId, message : message};


});

$(".confirmDelete").click(function () {
    const deleteMessage = {id : $(".confirmDelete").val(), message : null};

    $.post("/start",
        {
            command : "REMOVE_DATA",
            data : JSON.stringify(deleteMessage)
        }, request).fail(function () {
        window.location.href = serverErrorPage;
    });

    function request(response) {
        if (response.warn) {
            alert(response.warn);
        } else {
            alert(response.success);
            window.location.reload();
        }
    }
});