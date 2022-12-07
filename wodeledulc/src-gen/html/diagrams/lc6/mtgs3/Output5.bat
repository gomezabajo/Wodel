C:
cd \
cd CircuitMacros
cd dpic
m4 liblog.m4 C:/eclipse/runtime-EclipseApplication/wodeledulc/src-gen/html/diagrams/lc6/mtgs3/Output5.m4 | dpic -v > C:/eclipse/runtime-EclipseApplication/wodeledulc/src-gen/html/diagrams/lc6/mtgs3/Output5.svg
cd batik
java -Djava.awt.headless=true -jar batik-rasterizer.jar -m image/png -d C:/eclipse/runtime-EclipseApplication/wodeledulc/src-gen/html/diagrams/lc6/mtgs3/Output5.png C:/eclipse/runtime-EclipseApplication/wodeledulc/src-gen/html/diagrams/lc6/mtgs3/Output5.svg 2>&1
exit
