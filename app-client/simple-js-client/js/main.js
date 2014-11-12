// The root URL for the RESTful services
var REST_URL = "http://localhost:8080/users";

findAll();

function findAll() {
    console.log('findAll');
    $.ajax({
        type: 'GET',
        url: REST_URL,
        dataType: "json", // data type of response
        success: renderList,
        error: function(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR, textStatus, errorThrown);
            alert('findAll: ' + textStatus);
        }
    });
}

function renderList(data) {
// JAX-RS serializes an empty list as null, and a 'collection of one' as an object (not an 'array of one')
    var list = data == null ? [] : (data instanceof Array ? data : [data]);
    $('#userList li').remove();
    $.each(list, function (index, user) {
        $('#userList').append('<li><a href="#" data-identity="' + user.userId + '">' + user.login + "  "+ user.name + '</a></li>');
    });
}