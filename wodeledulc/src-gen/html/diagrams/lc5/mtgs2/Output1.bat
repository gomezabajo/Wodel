C:
cd \
cd CircuitMacros
cd dpic
m4 liblog.m4 C:/eclipse/runtime-EclipseApplication/wodeledulc/src-gen/html/diagrams/lc5/mtgs2/Output1.m4 | dpic -v > C:/eclipse/runtime-EclipseApplication/wodeledulc/src-gen/html/diagrams/lc5/mtgs2/Output1.svg
cd batik
java -Djava.awt.headless=true -jar batik-rasterizer.jar -m image/png -d C:/eclipse/runtime-EclipseApplication/wodeledulc/src-gen/html/diagrams/lc5/mtgs2/Output1.png C:/eclipse/runtime-EclipseApplication/wodeledulc/src-gen/html/diagrams/lc5/mtgs2/Output1.svg 2>&1
exit
