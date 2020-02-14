package cn.liboyan.bjuttourguide.travelingsalesman;

import cn.liboyan.bjuttourguide.ds.ArrayList;
import cn.liboyan.bjuttourguide.ds.GraphMatrix;
import cn.liboyan.bjuttourguide.ds.Vertex;

import java.util.Random;

/**
 * @author lbytony
 */
public class TravelingSalesmanSimulatedAnnealing extends TravelingSalesman {
    private double currentTemp = 5000;
    private double minTemp = 0.0001;
    private double internalLoop = 1000;
    private double coolingRate = 0.001;
    private ArrayList<Integer> currentSolution;
    private ArrayList<Integer> bestSolution;

    public TravelingSalesmanSimulatedAnnealing(int vertexNum) {
        super(vertexNum);
        currentSolution = new ArrayList<>(vertexNum);
    }

    /**
     * Creates a random individual
     **/
    private ArrayList<Integer> generateIndividual(ArrayList<Integer> solution) {
        int len = solution.getLength();
        int current;
        boolean[] selected = new boolean[len];
        ArrayList<Integer> result = new ArrayList<Integer>(len);
        // Shuffle ArrayList
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            do {
                current = random.nextInt() % len;
            } while (current < 0 || current > len || selected[current] != false);
            result.add(solution.getData(current));
            selected[current] = true;
        }
        return result;
    }

    /**
     * Create new neighbour tour
     **/
    public ArrayList<Integer> generateNeighbourTour(ArrayList<Integer> origin) {
        ArrayList<Integer> newSolution = new ArrayList<>(origin);
        // Get a random positions in the tour
        int tourPos1 = (int) (newSolution.getLength() * Math.random());
        int tourPos2 = (int) (newSolution.getLength() * Math.random());
        // Get the cities at selected positions in the tour
        int vertexSwap1 = newSolution.getData(tourPos1);
        int vertexSwap2 = newSolution.getData(tourPos2);
        // Swap them
        newSolution.setData(tourPos2, vertexSwap1);
        newSolution.setData(tourPos1, vertexSwap2);
        distance = 0;
        return newSolution;
    }

    /**
     * Calculate the acceptance probability
     **/
    private double acceptanceProbability(int energy, int newEnergy, double temp) {
        // If the new solution is better, accept it
        if (newEnergy < energy) {
            return 1.0;
        } else {
            // If the new solution is worse, calculate an acceptance probability: exp(dE / temp)
            return Math.exp((energy - newEnergy) / temp);
        }
    }

    private int getDistance(ArrayList<Integer> list) {
        if (distance == 0) {
            int tourDistance = 0;
            // Loop through our citiesList's cities
            for (int i = 0; i < list.getLength(); i++) {
                // Get city we're traveling from
                int fromCity = list.getData(i);
                // City we're traveling to
                int destinationCity;
                // Check we're not on our citiesList's last city, if we are set our
                // citiesList's final destination city to our starting city
                if (i + 1 < list.getLength()) {
                    destinationCity = list.getData(i + 1);
                } else {
                    destinationCity = list.getData(0);
                }
                // Get the distance between the two cities
                tourDistance += matrix[list.getPos(fromCity)][list.getPos(destinationCity)];
            }
            distance = tourDistance;
        }
        return distance;
    }

    @Override
    public void solve(GraphMatrix mapAll, ArrayList<Vertex> v) {
        super.solve(mapAll, v);
        for (int i = 0; i < vertexNum; i++) {
            currentSolution.add(v.getData(i).getId());
        }
        currentSolution = generateIndividual(currentSolution);

        bestSolution = new ArrayList<>(currentSolution);
        ArrayList<Integer> newSolution = null;
        // Loop until system has cooled
        while (currentTemp > minTemp) {
            for (int i = 0; i < internalLoop; i++) {
                // Get a solution from neighbour
                newSolution = generateNeighbourTour(currentSolution);
                // Get energy of solutions
                int currentEnergy = getDistance(currentSolution);
                int neighbourEnergy = getDistance(newSolution);
                // Decide if we should accept the neighbour
                if (acceptanceProbability(currentEnergy, neighbourEnergy, currentTemp) > Math.random()) {
                    currentSolution = new ArrayList<>(newSolution);
                }
                // Keep track of the best solution found
                if (getDistance(currentSolution) < getDistance(bestSolution)) {
                    bestSolution = new ArrayList<>(currentSolution);
                }
            }
            // Cool system
            currentTemp *= 1 - coolingRate;
        }
        for (int i = 0; i < vertexNum; i++) {
            path[i] = currentSolution.getData(i);
        }
    }
}