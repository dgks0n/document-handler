$(function() {
	var _menuVertical = $('.uiMenuBlockVertical');
	var _uploadForm = $('#formupload'); 
	var _inputFile = $('input[type="file"]');
	$('.uiCreationPane').on('click', 'div.uiJFKButtonNarrow', function(event) {
		event.stopPropagation();
		// Show Upload File(s) Menu
		_menuVertical.css({top: 144, left: 106, display: 'block'});
	});
	
	_menuVertical.on('click', '.uiMenuItem', function(event) {
		_inputFile.click();
	});
	
	$(document).click(function() {
		// Hidden Upload File(s) Menu when user click outside
        $('div.uiMenuBlockVertical').hide();
    });
	
	_uploadForm.fileupload({
		url: 'rest/document-service/document/upload',
		type: 'POST',
		dataType: 'json',
		singleFileUploads: true,
		multipart: 'multipart/form-data',
		acceptFileTypes: /(\.|\/)(gif|jpe?g|png)$/i,
		add: function(event, data) {
			data.submit();
			console.log("It is invoked as soon as files are added to the fileupload widget.");
		},
		done: function(event, data) {
			
		},
		fail: function(event, data) {
			console.log(data.jqXHR, data.textStatus, data.errorThrown);
		},
		always: function(event, data) {
			console.log(data.jqXHR, data.textStatus, data.errorThrown);
		}
	});
});