C:
cd \
cd CircuitMacros
cd dpic
m4 liblog.m4 C:/eclipse/runtime-EclipseApplication/wodeledulc/src-gen/html/diagrams/lc4/mtg2/mtg1/Output10/Output12.m4 | dpic -v > C:/eclipse/runtime-EclipseApplication/wodeledulc/src-gen/html/diagrams/lc4/mtg2/mtg1/Output10/Output12.svg
cd batik
java -Djava.awt.headless=true -jar batik-rasterizer.jar -m image/png -d C:/eclipse/runtime-EclipseApplication/wodeledulc/src-gen/html/diagrams/lc4/mtg2/mtg1/Output10/Output12.png C:/eclipse/runtime-EclipseApplication/wodeledulc/src-gen/html/diagrams/lc4/mtg2/mtg1/Output10/Output12.svg 2>&1
exit
