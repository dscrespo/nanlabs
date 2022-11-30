package com.nanlabs.trellomanagement.model.TO;

public enum Labels {

        MAINTENANCE("red"),
        RESEARCH("blue"),
        TEST("green");

        public final String label;

        private Labels(String label) {
            this.label = label;
        }

}
