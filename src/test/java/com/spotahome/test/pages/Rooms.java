package com.spotahome.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class Rooms extends BasePage {
    @FindBy(className = "l-list__item")
    List<WebElement> roomResults;

    public void selectRoom() {
        WebElement room = roomResults.get(new Random().ints(0, roomResults.size() - 1).findFirst().getAsInt());
        room.findElement(By.className("home-card")).click();
    }

    public void selectRoom(int index) {
        WebElement room = roomResults.get(index);
        room.findElement(By.className("home-card")).click();
    }
}
