package com.example.famto.entity;

import converter.DeliveryConvertor;
import converter.PickupConvertor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "task")
public class TaskModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int newId;

    @Column(name = "task_id")
    private String taskId;

    @Column(name = "assignee")
    private String assignee;

    @Column(name = "type")
    private String type;

    @Convert(converter = PickupConvertor.class)
    @Column(columnDefinition = "json", name = "pickup")
    private List<PickupModel> pickupDetails = new ArrayList<>();

    @Convert(converter = DeliveryConvertor.class)
    @Column(columnDefinition = "json", name = "delivery")
    private List<DeliveryModel> deliveryDetails = new ArrayList<>();


    @Column(name = "agent")
    private String agent;


    @Column(name = "status")
    private String status;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNewId() {
        return newId;
    }

    public void setNewId(int newId) {
        this.newId = newId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<PickupModel> getPickupDetails() {
        return pickupDetails;
    }

    public void setPickupDetails(List<PickupModel> pickupDetails) {
        this.pickupDetails = pickupDetails;
    }

    public List<DeliveryModel> getDeliveryDetails() {
        return deliveryDetails;
    }

    public void setDeliveryDetails(List<DeliveryModel> deliveryDetails) {
        this.deliveryDetails = deliveryDetails;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

}
