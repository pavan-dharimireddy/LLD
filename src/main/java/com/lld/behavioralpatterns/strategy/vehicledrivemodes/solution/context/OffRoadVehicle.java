package com.lld.behavioralpatterns.strategy.vehicledrivemodes.solution.context;

import com.lld.behavioralpatterns.strategy.vehicledrivemodes.solution.strategies.DriveStrategy;

// Concrete context subclass
public class OffRoadVehicle extends Vehicle {

    OffRoadVehicle(DriveStrategy driveStrategy) {
        super(driveStrategy);
    }
}
