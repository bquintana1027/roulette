package edu.cnm.deepdive.roulette.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import edu.cnm.deepdive.roulette.model.type.Color;

@Entity(
    foreignKeys = {
        @ForeignKey(
            entity= Spin.class,
            parentColumns = "spin_id", childColumns = "spin_id",
            onDelete = ForeignKey.CASCADE
        )
    }
)
public class Wager {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "wager id")
  private long id;

  @ColumnInfo(name="spin_id", index = true)
  private long spinId;

  private Color color;

  private String value;

  private boolean row;

  private int amount;

  @SuppressWarnings("NotNullFieldNotIntialized")
  @NonNull
  @Ignore
  private Spin spin;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getSpinId() {
    return spinId;
  }

  public void setSpinId(long spinId) {
    this.spinId = spinId;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public boolean isRow() {
    return row;
  }

  public void setRow(boolean row) {
    this.row = row;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }


  @NonNull
  public Spin getSpin() {
    return spin;
  }

  public void setSpin(@NonNull Spin spin) {
    this.spin = spin;
  }
}
