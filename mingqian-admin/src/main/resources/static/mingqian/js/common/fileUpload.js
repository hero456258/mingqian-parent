jQuery(function ($) {
    try {
        Dropzone.autoDiscover = false;

        var myDropzone = $("#dropzone").dropzone({
            previewTemplate: $('#preview-template').html(),
            thumbnailHeight: 120,
            thumbnailWidth: 120,
            maxFilesize: 10, //MB
            addRemoveLinks: true,
            dictRemoveFile: '删除图片',
            acceptedFiles: ".jpg,.png,.jpeg",
            dictFallbackMessage: "上传失败！",
            dictDefaultMessage: '点击或拖住文件到此处完成上传',
            thumbnail: function (file, dataUrl) {
                if (file.previewElement) {
                    $(file.previewElement).removeClass("dz-file-preview");
                    $(file.previewElement).find("[data-dz-thumbnail]").each(function () {
                        var thumbnailElement = this;
                        thumbnailElement.alt = file.name;
                        thumbnailElement.src = dataUrl;
                    });
                    setTimeout(function () {
                        $(file.previewElement).addClass("dz-image-preview");
                    }, 1);
                }
            },
            success: function (file, data) {
                if (data.resCode != 0) {
                    alert(data.msg);
                    return;
                }
                var picPath = data.result.path;
                if (file.previewElement) {
                    $(file.previewElement).find("[data-dz-thumbnail]").each(function () {
                        $(this).attr("attr_path", picPath);
                    });
                }
            }
        });

        var minSteps = 6,
            maxSteps = 60,
            timeBetweenSteps = 100,
            bytesPerStep = 100000;

        myDropzone.uploadFiles = function (files) {
            var self = this;

            for (var i = 0; i < files.length; i++) {
                var file = files[i];
                totalSteps = Math.round(Math.min(maxSteps, Math.max(minSteps, file.size / bytesPerStep)));

                for (var step = 0; step < totalSteps; step++) {
                    var duration = timeBetweenSteps * (step + 1);
                    setTimeout(function (file, totalSteps, step) {
                        return function () {
                            file.upload = {
                                progress: 100 * (step + 1) / totalSteps,
                                total: file.size,
                                bytesSent: (step + 1) * file.size / totalSteps
                            };
                            self.emit('uploadprogress', file, file.upload.progress, file.upload.bytesSent);
                            if (file.upload.progress == 100) {
                                file.status = Dropzone.SUCCESS;
                                self.emit("success", file, 'success', null);
                                self.emit("complete", file);
                                self.processQueue();
                            }
                        };
                    }(file, totalSteps, step), duration);
                }
            }
        }

        $(document).one('ajaxloadstart.page', function (e) {
            try {
                myDropzone.destroy();
            } catch (e) {
            }
        });
        $(".dz-remove").on("click", function (e) {
            $(this).parent().remove();
        });
    } catch (e) {
        alert('不支持的浏览器类型!');
    }

});
