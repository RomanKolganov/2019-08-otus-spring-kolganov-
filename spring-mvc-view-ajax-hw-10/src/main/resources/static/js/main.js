$(document).ready(function() {
    $(".ui.fluid.search.dropdown").dropdown({
        "fullTextSearch": true
    });

    $('.ui.form').form({
        on: 'blur',
        fields: {
            nameInput: {
                identifier : 'name',
                rules: [{type : 'empty'}]
            },
            txtInput: {
                identifier : 'text',
                rules: [{type : 'empty'}]
            },
            authorDropdown: {
                identifier : 'author_id',
                rules: [{type : 'empty'}]
            },
            genreDropdown: {
                identifier : 'genre_id',
                rules: [{type : 'empty'}]
            },
            bookDropdown: {
                identifier : 'book_id',
                rules: [{type : 'empty'}]
            }
        }
    });
});

function deleteEntity(url, id, table) {
    $.ajax({
        url: url,
        type: 'DELETE',
        data: {"id": id},
        success: function () {
            table.DataTable().ajax.reload();
        }
    });
}

function createEntity(url, data, table) {
    $.ajax({
        url: url,
        type: 'POST',
        data: data,
        success: function () {
            table.DataTable().ajax.reload();
        }
    });
}