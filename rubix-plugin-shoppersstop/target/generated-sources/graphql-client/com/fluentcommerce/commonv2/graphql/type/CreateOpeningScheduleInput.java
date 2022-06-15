package com.fluentcommerce.commonv2.graphql.type;

import com.apollographql.apollo.api.InputFieldMarshaller;
import com.apollographql.apollo.api.InputFieldWriter;
import java.io.IOException;
import java.lang.Override;
import javax.annotation.Generated;

@Generated("Apollo GraphQL")
public final class CreateOpeningScheduleInput {
  private final boolean allHours;

  private final int monStart;

  private final int monEnd;

  private final int tueStart;

  private final int tueEnd;

  private final int wedStart;

  private final int wedEnd;

  private final int thuStart;

  private final int thuEnd;

  private final int friStart;

  private final int friEnd;

  private final int satStart;

  private final int satEnd;

  private final int sunStart;

  private final int sunEnd;

  CreateOpeningScheduleInput(boolean allHours, int monStart, int monEnd, int tueStart, int tueEnd,
      int wedStart, int wedEnd, int thuStart, int thuEnd, int friStart, int friEnd, int satStart,
      int satEnd, int sunStart, int sunEnd) {
    this.allHours = allHours;
    this.monStart = monStart;
    this.monEnd = monEnd;
    this.tueStart = tueStart;
    this.tueEnd = tueEnd;
    this.wedStart = wedStart;
    this.wedEnd = wedEnd;
    this.thuStart = thuStart;
    this.thuEnd = thuEnd;
    this.friStart = friStart;
    this.friEnd = friEnd;
    this.satStart = satStart;
    this.satEnd = satEnd;
    this.sunStart = sunStart;
    this.sunEnd = sunEnd;
  }

  public boolean allHours() {
    return this.allHours;
  }

  public int monStart() {
    return this.monStart;
  }

  public int monEnd() {
    return this.monEnd;
  }

  public int tueStart() {
    return this.tueStart;
  }

  public int tueEnd() {
    return this.tueEnd;
  }

  public int wedStart() {
    return this.wedStart;
  }

  public int wedEnd() {
    return this.wedEnd;
  }

  public int thuStart() {
    return this.thuStart;
  }

  public int thuEnd() {
    return this.thuEnd;
  }

  public int friStart() {
    return this.friStart;
  }

  public int friEnd() {
    return this.friEnd;
  }

  public int satStart() {
    return this.satStart;
  }

  public int satEnd() {
    return this.satEnd;
  }

  public int sunStart() {
    return this.sunStart;
  }

  public int sunEnd() {
    return this.sunEnd;
  }

  public static Builder builder() {
    return new Builder();
  }

  public InputFieldMarshaller marshaller() {
    return new InputFieldMarshaller() {
      @Override
      public void marshal(InputFieldWriter writer) throws IOException {
        writer.writeBoolean("allHours", allHours);
        writer.writeInt("monStart", monStart);
        writer.writeInt("monEnd", monEnd);
        writer.writeInt("tueStart", tueStart);
        writer.writeInt("tueEnd", tueEnd);
        writer.writeInt("wedStart", wedStart);
        writer.writeInt("wedEnd", wedEnd);
        writer.writeInt("thuStart", thuStart);
        writer.writeInt("thuEnd", thuEnd);
        writer.writeInt("friStart", friStart);
        writer.writeInt("friEnd", friEnd);
        writer.writeInt("satStart", satStart);
        writer.writeInt("satEnd", satEnd);
        writer.writeInt("sunStart", sunStart);
        writer.writeInt("sunEnd", sunEnd);
      }
    };
  }

  public static final class Builder {
    private boolean allHours;

    private int monStart;

    private int monEnd;

    private int tueStart;

    private int tueEnd;

    private int wedStart;

    private int wedEnd;

    private int thuStart;

    private int thuEnd;

    private int friStart;

    private int friEnd;

    private int satStart;

    private int satEnd;

    private int sunStart;

    private int sunEnd;

    Builder() {
    }

    public Builder allHours(boolean allHours) {
      this.allHours = allHours;
      return this;
    }

    public Builder monStart(int monStart) {
      this.monStart = monStart;
      return this;
    }

    public Builder monEnd(int monEnd) {
      this.monEnd = monEnd;
      return this;
    }

    public Builder tueStart(int tueStart) {
      this.tueStart = tueStart;
      return this;
    }

    public Builder tueEnd(int tueEnd) {
      this.tueEnd = tueEnd;
      return this;
    }

    public Builder wedStart(int wedStart) {
      this.wedStart = wedStart;
      return this;
    }

    public Builder wedEnd(int wedEnd) {
      this.wedEnd = wedEnd;
      return this;
    }

    public Builder thuStart(int thuStart) {
      this.thuStart = thuStart;
      return this;
    }

    public Builder thuEnd(int thuEnd) {
      this.thuEnd = thuEnd;
      return this;
    }

    public Builder friStart(int friStart) {
      this.friStart = friStart;
      return this;
    }

    public Builder friEnd(int friEnd) {
      this.friEnd = friEnd;
      return this;
    }

    public Builder satStart(int satStart) {
      this.satStart = satStart;
      return this;
    }

    public Builder satEnd(int satEnd) {
      this.satEnd = satEnd;
      return this;
    }

    public Builder sunStart(int sunStart) {
      this.sunStart = sunStart;
      return this;
    }

    public Builder sunEnd(int sunEnd) {
      this.sunEnd = sunEnd;
      return this;
    }

    public CreateOpeningScheduleInput build() {
      return new CreateOpeningScheduleInput(allHours, monStart, monEnd, tueStart, tueEnd, wedStart, wedEnd, thuStart, thuEnd, friStart, friEnd, satStart, satEnd, sunStart, sunEnd);
    }
  }
}
