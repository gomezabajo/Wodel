<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm version="1.0" name="0">
	<cp>
		<constant value="constraints"/>
		<constant value="links"/>
		<constant value="NTransientLinkSet;"/>
		<constant value="col"/>
		<constant value="J"/>
		<constant value="constraint1"/>
		<constant value="main"/>
		<constant value="A"/>
		<constant value="OclParametrizedType"/>
		<constant value="#native"/>
		<constant value="Collection"/>
		<constant value="J.setName(S):V"/>
		<constant value="OclSimpleType"/>
		<constant value="OclAny"/>
		<constant value="J.setElementType(J):V"/>
		<constant value="B"/>
		<constant value="ABCD"/>
		<constant value="J.allInstances():J"/>
		<constant value="1"/>
		<constant value="aBooleanAttr"/>
		<constant value="J.=(J):J"/>
		<constant value="B.or(B):B"/>
		<constant value="TransientLinkSet"/>
		<constant value="A.__matcher__():V"/>
		<constant value="A.__exec__():V"/>
		<constant value="6:38-6:44"/>
		<constant value="6:38-6:59"/>
		<constant value="6:72-6:73"/>
		<constant value="6:72-6:86"/>
		<constant value="6:89-6:93"/>
		<constant value="6:72-6:93"/>
		<constant value="6:38-6:94"/>
		<constant value="a"/>
		<constant value="self"/>
		<constant value="__resolve__"/>
		<constant value="J.oclIsKindOf(J):B"/>
		<constant value="18"/>
		<constant value="NTransientLinkSet;.getLinkBySourceElement(S):QNTransientLink;"/>
		<constant value="J.oclIsUndefined():B"/>
		<constant value="15"/>
		<constant value="NTransientLink;.getTargetFromSource(J):J"/>
		<constant value="17"/>
		<constant value="30"/>
		<constant value="Sequence"/>
		<constant value="2"/>
		<constant value="A.__resolve__(J):J"/>
		<constant value="QJ.including(J):QJ"/>
		<constant value="QJ.flatten():QJ"/>
		<constant value="e"/>
		<constant value="value"/>
		<constant value="resolveTemp"/>
		<constant value="S"/>
		<constant value="NTransientLink;.getNamedTargetFromSource(JS):J"/>
		<constant value="name"/>
		<constant value="__matcher__"/>
		<constant value="__exec__"/>
	</cp>
	<field name="1" type="2"/>
	<field name="3" type="4"/>
	<field name="5" type="4"/>
	<operation name="6">
		<context type="7"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<push arg="8"/>
			<push arg="9"/>
			<new/>
			<dup/>
			<push arg="10"/>
			<pcall arg="11"/>
			<dup/>
			<push arg="12"/>
			<push arg="9"/>
			<new/>
			<dup/>
			<push arg="13"/>
			<pcall arg="11"/>
			<pcall arg="14"/>
			<set arg="3"/>
			<getasm/>
			<pushf/>
			<push arg="15"/>
			<push arg="16"/>
			<findme/>
			<call arg="17"/>
			<iterate/>
			<store arg="18"/>
			<load arg="18"/>
			<get arg="19"/>
			<pusht/>
			<call arg="20"/>
			<call arg="21"/>
			<enditerate/>
			<set arg="5"/>
			<getasm/>
			<push arg="22"/>
			<push arg="9"/>
			<new/>
			<set arg="1"/>
			<getasm/>
			<pcall arg="23"/>
			<getasm/>
			<pcall arg="24"/>
		</code>
		<linenumbertable>
			<lne id="25" begin="18" end="20"/>
			<lne id="26" begin="18" end="21"/>
			<lne id="27" begin="24" end="24"/>
			<lne id="28" begin="24" end="25"/>
			<lne id="29" begin="26" end="26"/>
			<lne id="30" begin="24" end="27"/>
			<lne id="31" begin="17" end="29"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="32" begin="23" end="28"/>
			<lve slot="0" name="33" begin="0" end="39"/>
		</localvariabletable>
	</operation>
	<operation name="34">
		<context type="7"/>
		<parameters>
			<parameter name="18" type="4"/>
		</parameters>
		<code>
			<load arg="18"/>
			<getasm/>
			<get arg="3"/>
			<call arg="35"/>
			<if arg="36"/>
			<getasm/>
			<get arg="1"/>
			<load arg="18"/>
			<call arg="37"/>
			<dup/>
			<call arg="38"/>
			<if arg="39"/>
			<load arg="18"/>
			<call arg="40"/>
			<goto arg="41"/>
			<pop/>
			<load arg="18"/>
			<goto arg="42"/>
			<push arg="43"/>
			<push arg="9"/>
			<new/>
			<load arg="18"/>
			<iterate/>
			<store arg="44"/>
			<getasm/>
			<load arg="44"/>
			<call arg="45"/>
			<call arg="46"/>
			<enditerate/>
			<call arg="47"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="48" begin="23" end="27"/>
			<lve slot="0" name="33" begin="0" end="29"/>
			<lve slot="1" name="49" begin="0" end="29"/>
		</localvariabletable>
	</operation>
	<operation name="50">
		<context type="7"/>
		<parameters>
			<parameter name="18" type="4"/>
			<parameter name="44" type="51"/>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<load arg="18"/>
			<call arg="37"/>
			<load arg="18"/>
			<load arg="44"/>
			<call arg="52"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="33" begin="0" end="6"/>
			<lve slot="1" name="49" begin="0" end="6"/>
			<lve slot="2" name="53" begin="0" end="6"/>
		</localvariabletable>
	</operation>
	<operation name="54">
		<context type="7"/>
		<parameters>
		</parameters>
		<code>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="33" begin="0" end="-1"/>
		</localvariabletable>
	</operation>
	<operation name="55">
		<context type="7"/>
		<parameters>
		</parameters>
		<code>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="33" begin="0" end="-1"/>
		</localvariabletable>
	</operation>
</asm>
