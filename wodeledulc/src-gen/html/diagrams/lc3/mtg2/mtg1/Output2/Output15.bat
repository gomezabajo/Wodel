C:
cd \
cd CircuitMacros
cd dpic
m4 liblog.m4 C:/eclipse/runtime-EclipseApplication/wodeledulc/src-gen/html/diagrams/lc3/mtg2/mtg1/Output2/Output15.m4 | dpic -v > C:/eclipse/runtime-EclipseApplication/wodeledulc/src-gen/html/diagrams/lc3/mtg2/mtg1/Output2/Output15.svg
cd batik
java -Djava.awt.headless=true -jar batik-rasterizer.jar -m image/png -d C:/eclipse/runtime-EclipseApplication/wodeledulc/src-gen/html/diagrams/lc3/mtg2/mtg1/Output2/Output15.png C:/eclipse/runtime-EclipseApplication/wodeledulc/src-gen/html/diagrams/lc3/mtg2/mtg1/Output2/Output15.svg 2>&1
exit
