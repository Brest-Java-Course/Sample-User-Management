// The root URL for the RESTful services
var REST_URL = "http://localhost:8080/users";
var currentUser;

findAll();

$('#btnAdd').click(function () {
    newUser();
    return false;
});

$('#btnSave').click(function () {
    if ($('#userId').val() == '')
        addUser();
    else
        updateUser();
    return false;
});

function addUser() {
    console.log('addUser');
    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: REST_URL,
        dataType: "json",
        data: formToJSON(),
        success: function (data, textStatus, jqXHR) {
            alert('User created successfully');
            $('#userId').val(data.userId);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('addUser error: ' + textStatus);
        }
    });
}
function updateUser() {
    console.log('updateUser');
    $.ajax({
        type: 'PUT',
        contentType: 'application/json',
        url: REST_URL + '/' + $('#userId').val(),
        dataType: "json",
        data: formToJSON(),
        success: function (data, textStatus, jqXHR) {
            alert('User updated successfully');
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('updateUser error: ' + textStatus);
        }
    });
}

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

function newUser() {
    currentUser = {};
    renderDetails(currentUser); // Display empty form
}

function renderDetails(user) {
    $('#userId').val(user.userId);
    $('#login').val(user.login);
    $('#name').val(user.name);
}

// Helper function to serialize all the form fields into a JSON string
function formToJSON() {
    var userId = $('#userId').val();
    return JSON.stringify({
        "userId": userId == "" ? null : userId,
        "login": $('#login').val(),
        "name": $('#name').val()
    });
}