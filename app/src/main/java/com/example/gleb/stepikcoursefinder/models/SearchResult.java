
package com.example.gleb.stepikcoursefinder.models;
//сгенерировано с помощью http://www.jsonschema2pojo.org/
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchResult {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("position")
    @Expose
    private Integer position;
    @SerializedName("score")
    @Expose
    private Double score;
    @SerializedName("target_id")
    @Expose
    private Integer targetId;
    @SerializedName("target_type")
    @Expose
    private String targetType;
    @SerializedName("course")
    @Expose
    private Integer course;
    @SerializedName("course_owner")
    @Expose
    private Integer courseOwner;
    @SerializedName("course_authors")
    @Expose
    private List<Integer> courseAuthors = null;
    @SerializedName("course_title")
    @Expose
    private String courseTitle;
    @SerializedName("course_slug")
    @Expose
    private String courseSlug;
    @SerializedName("course_cover")
    @Expose
    private String courseCover;
    @SerializedName("lesson")
    @Expose
    private Object lesson;
    @SerializedName("lesson_owner")
    @Expose
    private Object lessonOwner;
    @SerializedName("lesson_title")
    @Expose
    private Object lessonTitle;
    @SerializedName("lesson_slug")
    @Expose
    private Object lessonSlug;
    @SerializedName("lesson_cover_url")
    @Expose
    private Object lessonCoverUrl;
    @SerializedName("step")
    @Expose
    private Object step;
    @SerializedName("step_position")
    @Expose
    private Object stepPosition;
    @SerializedName("comment")
    @Expose
    private Object comment;
    @SerializedName("comment_parent")
    @Expose
    private Object commentParent;
    @SerializedName("comment_user")
    @Expose
    private Object commentUser;
    @SerializedName("comment_text")
    @Expose
    private Object commentText;

    public SearchResult(){

    }

    public SearchResult(Integer id, Integer position, Double score, Integer targetId, String targetType, Integer course, Integer courseOwner, List<Integer> courseAuthors, String courseTitle, String courseSlug, String courseCover, Object lesson, Object lessonOwner, Object lessonTitle, Object lessonSlug, Object lessonCoverUrl, Object step, Object stepPosition, Object comment, Object commentParent, Object commentUser, Object commentText) {
        this.id = id;
        this.position = position;
        this.score = score;
        this.targetId = targetId;
        this.targetType = targetType;
        this.course = course;
        this.courseOwner = courseOwner;
        this.courseAuthors = courseAuthors;
        this.courseTitle = courseTitle;
        this.courseSlug = courseSlug;
        this.courseCover = courseCover;
        this.lesson = lesson;
        this.lessonOwner = lessonOwner;
        this.lessonTitle = lessonTitle;
        this.lessonSlug = lessonSlug;
        this.lessonCoverUrl = lessonCoverUrl;
        this.step = step;
        this.stepPosition = stepPosition;
        this.comment = comment;
        this.commentParent = commentParent;
        this.commentUser = commentUser;
        this.commentText = commentText;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public Integer getCourseOwner() {
        return courseOwner;
    }

    public void setCourseOwner(Integer courseOwner) {
        this.courseOwner = courseOwner;
    }

    public List<Integer> getCourseAuthors() {
        return courseAuthors;
    }

    public void setCourseAuthors(List<Integer> courseAuthors) {
        this.courseAuthors = courseAuthors;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseSlug() {
        return courseSlug;
    }

    public void setCourseSlug(String courseSlug) {
        this.courseSlug = courseSlug;
    }

    public String getCourseCover() {
        return courseCover;
    }

    public void setCourseCover(String courseCover) {
        this.courseCover = courseCover;
    }

    public Object getLesson() {
        return lesson;
    }

    public void setLesson(Object lesson) {
        this.lesson = lesson;
    }

    public Object getLessonOwner() {
        return lessonOwner;
    }

    public void setLessonOwner(Object lessonOwner) {
        this.lessonOwner = lessonOwner;
    }

    public Object getLessonTitle() {
        return lessonTitle;
    }

    public void setLessonTitle(Object lessonTitle) {
        this.lessonTitle = lessonTitle;
    }

    public Object getLessonSlug() {
        return lessonSlug;
    }

    public void setLessonSlug(Object lessonSlug) {
        this.lessonSlug = lessonSlug;
    }

    public Object getLessonCoverUrl() {
        return lessonCoverUrl;
    }

    public void setLessonCoverUrl(Object lessonCoverUrl) {
        this.lessonCoverUrl = lessonCoverUrl;
    }

    public Object getStep() {
        return step;
    }

    public void setStep(Object step) {
        this.step = step;
    }

    public Object getStepPosition() {
        return stepPosition;
    }

    public void setStepPosition(Object stepPosition) {
        this.stepPosition = stepPosition;
    }

    public Object getComment() {
        return comment;
    }

    public void setComment(Object comment) {
        this.comment = comment;
    }

    public Object getCommentParent() {
        return commentParent;
    }

    public void setCommentParent(Object commentParent) {
        this.commentParent = commentParent;
    }

    public Object getCommentUser() {
        return commentUser;
    }

    public void setCommentUser(Object commentUser) {
        this.commentUser = commentUser;
    }

    public Object getCommentText() {
        return commentText;
    }

    public void setCommentText(Object commentText) {
        this.commentText = commentText;
    }

}
