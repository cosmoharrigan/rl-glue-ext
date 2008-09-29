/* 
 * Copyright (C) 2007, Brian Tanner
 * 
http://rl-glue.googlecode.com/
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
* 
*  $Revision$
*  $Date$
*  $Author$
*  $HeadURL$
* 
*/

package org.rlcommunity.rlglue.codec.types;

public class Reward_observation {

    public double r;
    public Observation o;
    public int terminal;

    public Reward_observation() {
        r=0;
        o=new Observation();
        terminal=0;
    }
    

    public Reward_observation(double reward, Observation observation, int terminal) {
        this(reward,observation,terminal==1);
    }

   /**
     * @since 2.0 Want to move towards using terminal as a boolean not an int.
     */
    public Reward_observation(double reward, Observation observation, boolean terminal) {
        this.r = reward;
        this.o = observation;
        if(terminal){
            this.terminal = 1;
        }else{
            this.terminal = 0;
        }
    }

    /**
     * This is a deep copy constructor
     * @param src
     */
    public Reward_observation(Reward_observation src) {
        this.o = src.o.duplicate();
        this.r = src.r;
        this.terminal = src.terminal;
    }
    
   /**
     * @since 2.0 Want to move towards using terminal as a boolean not an int.
     * @return boolean representation of whether the episode is over.
     */
    public boolean isTerminal(){
        return terminal==1;
    }


    public Reward_observation duplicate() {
        return new Reward_observation(this);
    }
}