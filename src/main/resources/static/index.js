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
            eTable += "<tr>" + "<th>" + "<ul>";
            $.each(JSON.parse(value), function (index, iValue) {
                eTable += "<li>" + iValue.name + "</li>";
            });
            eTable += "</th>" + "<th>" + "<li>" + index + "</li>";
            eTable += "</ul>" + "</th>" + "</tr>";
        });
        $(".wrapper").html(eTable);
    }
});

$(".btnAdd").click(function () {
    const cities = [];
    cities.push("Нью-Йорк");
    cities.push("Нью-Ёрк");
    const message = "В Нью-Йорке можно";
    let newData = { message : message, cities : cities};
    $.post("/start",
        {
            command : "ADD_DATA",
            new : JSON.stringify(newData)
        }, request).fail(function () {
        window.location.href = serverErrorPage;
    });

    function request(response) {
        if (response.exist) {
            alert(response.exist);
        } else {
            alert(response.success);
        }
    }
});

$(".btnAddCity").click(function () {
    const cities = [];
    cities.push("Нью-Йорк");
    cities.push("Нью-Ёрк");
    cities.push("Нью Йорк");
    const message = "В Нью-Йорке можно посетить следующие места: Статуя Свободы, Таймс Сквер и Небоскреб Эмпайр-стейт-Билдинг.";
    const messageId = 6;
    let updateData = { message : message, cities : cities, messageId : messageId};

    const newCity = {id : null, name : "Нью Йорк", messageId : 6};

    $.post("/start",
        {
            command : "ADD_CITY",
            new : JSON.stringify(newCity)
        }, request).fail(function () {
        window.location.href = serverErrorPage;
    });

    function request(response) {
        if (response.exist) {
            alert(response.exist);
        } else {
            alert(response.success);
        }
    }
});

$(".btnUpdateMessage").click(function () {
    const cities = [];
    cities.push("Нью-Йорк");
    cities.push("Нью-Ёрк");
    cities.push("Нью Йорк");
    const message = "В Нью-Йорке можно посетить следующие места: Статуя Свободы, Таймс Сквер и Небоскреб Эмпайр-стейт-Билдинг.";
    const messageId = 6;
    let updateData = { message : message, cities : cities, messageId : messageId};

    const updateMessage = {id : messageId, message : message};

    $.post("/start",
        {
            command : "UPDATE_MESSAGE",
            new : JSON.stringify(updateMessage)
        }, request).fail(function () {
        window.location.href = serverErrorPage;
    });

    function request(response) {
        if (response.exist) {
            alert(response.exist);
        } else {
            alert(response.success);
        }
    }
});

$(".btnDeleteCities").click(function () {
    const cities = [];
    cities.push({id : 7, name : "САНКТПЕТЕРБУРГ", messageId : 5});
    cities.push({id : 8, name : "САНТ-ПЕТЕРБУРГ", messageId : 5});
    cities.push({id : 9, name : "САНТ ПЕТЕРБУРГ", messageId : 5});

    $.post("/start",
        {
            command : "REMOVE_CITY",
            new : JSON.stringify(cities)
        }, request).fail(function () {
        window.location.href = serverErrorPage;
    });

    function request(response) {
        if (response.exist) {
            alert(response.exist);
        } else {
            alert(response.success);
        }
    }
});

$(".btnDelete").click(function () {
    const message = "В Нью-Йорке можно посетить следующие места: Статуя Свободы, Таймс Сквер и Небоскреб Эмпайр-стейт-Билдинг.";
    const messageId = 6;

    const deleteMessage = {id : messageId, message : message};

    $.post("/start",
        {
            command : "REMOVE_DATA",
            new : JSON.stringify(deleteMessage)
        }, request).fail(function () {
        window.location.href = serverErrorPage;
    });

    function request(response) {
        if (response.exist) {
            alert(response.exist);
        } else {
            alert(response.success);
        }
    }
});