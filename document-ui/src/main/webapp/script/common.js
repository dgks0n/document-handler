$(function() {
	'use strict';
	
	$('.uiCreationPane').on('click', 'div.uiJFKButtonNarrow', function(event) {
		event.preventDefault();
		event.stopPropagation();
		
		// Show Upload File(s) Menu
		$('.uiMenuBlockVertical').css({top: 144, left: 106, display: 'block'});
	});
	
	$('.uiMenuBlockVertical').on('click', '.uiMenuItem', function(event) {
		$('input[type="file"]').click();
	});
	
	$(document).click(function() {
		// Hidden Upload File(s) Menu when user click outside
        $('div.uiMenuBlockVertical').hide();
    });
	
	$('input[type="file"]').fileupload({
		url: 'rest/document-service/document/upload',
		type: 'POST',
		dataType: 'json',
		singleFileUploads: true,
		multipart: 'multipart/form-data',
		add: function(event, data) {
			var fileItem = data.files[0];
			var fileType = fileItem.name ? fileItem.name : fileItem;
			if ($.acceptFileTypes(fileType)) {
				data.submit();
			} else {
				$.showError('Not Supported File Format', 
						'Cannot upload the file. The format (' + $.fileExtension(fileType) + ') is not supported.');
				return false;
			}
		},
		done: function(event, data) {
			console.log(data.textStatus, data.result);
		},
		fail: function(event, data) {
			$.showError(data.errorThrown, data.jqXHR.responseJSON.message);
		}
	});
	
	// Customize jQuery
	$.extend({
		fileExtension: function(fileItem) {
			var fileExt = "";
			if (fileItem) {
				fileExt = fileItem.split('.').pop();
				return fileExt;
			}
			return fileExt;
		},
		acceptFileTypes: function(fileType) {
			var isAcceptFiletypes = false;
			var regExp = new RegExp(/(\.|\/)(doc?x|xls?x|ppt?x|txt|gif|pdf|odt|odp|csv)$/i);
			if (regExp.test(fileType)) {
				isAcceptFiletypes = true;
			}
			
			return isAcceptFiletypes;
		},
		showError: function(title, errorMessage) {
			BootstrapDialog.show({
		        title: title,
		        message: errorMessage
		    });
		}
	});
});
