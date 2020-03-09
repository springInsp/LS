package com.bignerdranch.android.liveschedule.Models;

public class Task {

    String id_task, title, body, id_urgency, create_date, create_time,
            start_date, start_time, end_date, end_time, supervisor,
            taskcol, id_parent, description;
    boolean is_done;

    public Task() {}

    public Task(String id_task, String title, String body, String id_urgency, String create_date,
                String create_time, String start_date, String start_time, String end_date, String end_time,
                String supervisor, String taskcol, String id_parent, String description, boolean is_done) {
        this.id_task = id_task;
        this.title = title;
        this.body = body;
        this.id_urgency = id_urgency;
        this.create_date = create_date;
        this.create_time = create_time;
        this.start_date = start_date;
        this.start_time = start_time;
        this.end_date = end_date;
        this.end_time = end_time;
        this.supervisor = supervisor;
        this.taskcol = taskcol;
        this.id_parent = id_parent;
        this.description = description;
        this.is_done = is_done;
    }

    public String getId_task() {
        return id_task;
    }

    public void setId_task(String id_task) {
        this.id_task = id_task;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getId_urgency() {
        return id_urgency;
    }

    public void setId_urgency(String id_urgency) {
        this.id_urgency = id_urgency;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getTaskcol() {
        return taskcol;
    }

    public void setTaskcol(String taskcol) {
        this.taskcol = taskcol;
    }

    public String getId_parent() {
        return id_parent;
    }

    public void setId_parent(String id_parent) {
        this.id_parent = id_parent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIs_done() {
        return is_done;
    }

    public void setIs_done(boolean is_done) {
        this.is_done = is_done;
    }
}
