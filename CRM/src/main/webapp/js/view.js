/**
 * Created by Administrator on 2016/11/29.
 */
document.write("<script language=javascript src='backbone/backbone.js'></script>");
var TodoView = Backbone.View.extend({
    template: _.template("html/guest.html"),
    initialize: function () {

    },
    render: function () {
        $(this.el).html(this.template(this.model.toJSON()));
        return this;
    }
});