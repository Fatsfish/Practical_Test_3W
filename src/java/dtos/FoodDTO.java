/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

/**
 *
 * @author User-PC
 */
public class FoodDTO {

    private String ID;
    private String Name;
    private String Description;
    private String Price;
    private String CookingTime;
    private boolean isDelete;
    private String CreateDate;

    public FoodDTO() {
    }

    public FoodDTO(String ID, String Name, String Description, String Price, String CookingTime, boolean isDelete, String CreateDate) {
        this.ID = ID;
        this.Name = Name;
        this.Description = Description;
        this.Price = Price;
        this.CookingTime = CookingTime;
        this.isDelete = isDelete;
        this.CreateDate = CreateDate;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getDescription() {
        return Description;
    }

    public String getPrice() {
        return Price;
    }

    public String getCookingTime() {
        return CookingTime;
    }

    public boolean isIsDelete() {
        return isDelete;
    }

    public String getCreateDate() {
        return CreateDate;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public void setCookingTime(String CookingTime) {
        this.CookingTime = CookingTime;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public void setCreateDate(String CreateDate) {
        this.CreateDate = CreateDate;
    }

}
