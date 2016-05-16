var gulp = require("gulp"),//http://gulpjs.com/
    util = require("gulp-util"),//https://github.com/gulpjs/gulp-util
    sass = require("gulp-sass"),//https://www.npmjs.org/package/gulp-sass
    autoprefixer = require('gulp-autoprefixer'),//https://www.npmjs.org/package/gulp-autoprefixer
    minifycss = require('gulp-minify-css'),//https://www.npmjs.org/package/gulp-minify-css
    rename = require('gulp-rename'),//https://www.npmjs.org/package/gulp-rename
    log = util.log;

/* require = launch concrete js-plugin (f.e.: gulp-minify-css, gulp-rename, etc).
* */

var cssTarget = "src/main/webapp/resources/css/";
/*var cssTargetImages = "src/main/webapp/resources/images"*/

/*gulp.task("default", ["sass", "copyResources"]);*/
gulp.task("default", ["sass"]);

gulp.task("sass", function () {
    log("Generating CSS files " + (new Date()).toString());
    gulp.src("src/main/resources/scss/all.scss")
        .pipe(sass({style: 'expanded'}))
        .pipe(autoprefixer("last 3 version", "safari 5", "ie 9"))
        .pipe(gulp.dest(cssTarget))
        .pipe(rename({suffix: '.min'}))
        .pipe(minifycss())
        .pipe(gulp.dest(cssTarget));
});

gulp.task("watch", function () {
    log("Watching scss files for modifications");
    gulp.watch(sassFiles, ["sass"]);
});

/*gulp.task("copyResources", function () {
    log("copyResources (icons)");
    gulp.src("node_modules/material-design-icons/action/1x_web/ic_youtube_searched_for_black_48dp.png")
        .pipe(gulp.dest(cssTargetImages))
});*/


