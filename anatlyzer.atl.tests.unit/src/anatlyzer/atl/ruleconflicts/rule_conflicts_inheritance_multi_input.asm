<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm version="1.0" name="0">
	<cp>
		<constant value="conflictsinheritance"/>
		<constant value="links"/>
		<constant value="NTransientLinkSet;"/>
		<constant value="col"/>
		<constant value="J"/>
		<constant value="main"/>
		<constant value="A"/>
		<constant value="OclParametrizedType"/>
		<constant value="#native"/>
		<constant value="Collection"/>
		<constant value="J.setName(S):V"/>
		<constant value="OclSimpleType"/>
		<constant value="OclAny"/>
		<constant value="J.setElementType(J):V"/>
		<constant value="TransientLinkSet"/>
		<constant value="A.__matcher__():V"/>
		<constant value="A.__exec__():V"/>
		<constant value="self"/>
		<constant value="__resolve__"/>
		<constant value="1"/>
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
		<constant value="A.__matchmultiple():V"/>
		<constant value="__exec__"/>
		<constant value="multiple"/>
		<constant value="NTransientLinkSet;.getLinksByRule(S):QNTransientLink;"/>
		<constant value="A.__applymultiple(NTransientLink;):V"/>
		<constant value="simple"/>
		<constant value="A.__applysimple(NTransientLink;):V"/>
		<constant value="__matchmultiple"/>
		<constant value="ABCD"/>
		<constant value="IN"/>
		<constant value="MMOF!Classifier;.allInstancesFrom(S):QJ"/>
		<constant value="B"/>
		<constant value="C"/>
		<constant value="B.not():B"/>
		<constant value="45"/>
		<constant value="TransientLink"/>
		<constant value="NTransientLink;.setRule(MATL!Rule;):V"/>
		<constant value="a"/>
		<constant value="NTransientLink;.addSourceElement(SJ):V"/>
		<constant value="tgt"/>
		<constant value="W"/>
		<constant value="WXYZ"/>
		<constant value="NTransientLink;.addTargetElement(SJ):V"/>
		<constant value="NTransientLinkSet;.addLink2(NTransientLink;B):V"/>
		<constant value="13:27-13:31"/>
		<constant value="14:14-16:10"/>
		<constant value="b"/>
		<constant value="__applysimple"/>
		<constant value="NTransientLink;"/>
		<constant value="NTransientLink;.getSourceElement(S):J"/>
		<constant value="3"/>
		<constant value="NTransientLink;.getTargetElement(S):J"/>
		<constant value="4"/>
		<constant value="Wsimple"/>
		<constant value="15:18-15:27"/>
		<constant value="15:10-15:27"/>
		<constant value="link"/>
	</cp>
	<field name="1" type="2"/>
	<field name="3" type="4"/>
	<operation name="5">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<push arg="7"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="9"/>
			<pcall arg="10"/>
			<dup/>
			<push arg="11"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="12"/>
			<pcall arg="10"/>
			<pcall arg="13"/>
			<set arg="3"/>
			<getasm/>
			<push arg="14"/>
			<push arg="8"/>
			<new/>
			<set arg="1"/>
			<getasm/>
			<pcall arg="15"/>
			<getasm/>
			<pcall arg="16"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="24"/>
		</localvariabletable>
	</operation>
	<operation name="18">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
		</parameters>
		<code>
			<load arg="19"/>
			<getasm/>
			<get arg="3"/>
			<call arg="20"/>
			<if arg="21"/>
			<getasm/>
			<get arg="1"/>
			<load arg="19"/>
			<call arg="22"/>
			<dup/>
			<call arg="23"/>
			<if arg="24"/>
			<load arg="19"/>
			<call arg="25"/>
			<goto arg="26"/>
			<pop/>
			<load arg="19"/>
			<goto arg="27"/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<load arg="19"/>
			<iterate/>
			<store arg="29"/>
			<getasm/>
			<load arg="29"/>
			<call arg="30"/>
			<call arg="31"/>
			<enditerate/>
			<call arg="32"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="33" begin="23" end="27"/>
			<lve slot="0" name="17" begin="0" end="29"/>
			<lve slot="1" name="34" begin="0" end="29"/>
		</localvariabletable>
	</operation>
	<operation name="35">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
			<parameter name="29" type="36"/>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<load arg="19"/>
			<call arg="22"/>
			<load arg="19"/>
			<load arg="29"/>
			<call arg="37"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="6"/>
			<lve slot="1" name="34" begin="0" end="6"/>
			<lve slot="2" name="38" begin="0" end="6"/>
		</localvariabletable>
	</operation>
	<operation name="39">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<pcall arg="40"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="1"/>
		</localvariabletable>
	</operation>
	<operation name="41">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="42"/>
			<call arg="43"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<pcall arg="44"/>
			<enditerate/>
			<getasm/>
			<get arg="1"/>
			<push arg="45"/>
			<call arg="43"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<pcall arg="46"/>
			<enditerate/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="33" begin="5" end="8"/>
			<lve slot="1" name="33" begin="15" end="18"/>
			<lve slot="0" name="17" begin="0" end="19"/>
		</localvariabletable>
	</operation>
	<operation name="47">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="6"/>
			<push arg="48"/>
			<findme/>
			<push arg="49"/>
			<call arg="50"/>
			<iterate/>
			<store arg="19"/>
			<push arg="51"/>
			<push arg="48"/>
			<findme/>
			<push arg="49"/>
			<call arg="50"/>
			<iterate/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="52"/>
			<push arg="48"/>
			<findme/>
			<call arg="20"/>
			<call arg="53"/>
			<if arg="54"/>
			<pusht/>
			<call arg="53"/>
			<if arg="54"/>
			<getasm/>
			<get arg="1"/>
			<push arg="55"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="45"/>
			<pcall arg="56"/>
			<dup/>
			<push arg="57"/>
			<load arg="19"/>
			<pcall arg="58"/>
			<dup/>
			<push arg="59"/>
			<push arg="60"/>
			<push arg="61"/>
			<new/>
			<pcall arg="62"/>
			<pusht/>
			<pcall arg="63"/>
			<goto arg="54"/>
			<enditerate/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="64" begin="21" end="21"/>
			<lne id="65" begin="36" end="41"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="57" begin="6" end="44"/>
			<lve slot="2" name="66" begin="13" end="45"/>
			<lve slot="0" name="17" begin="0" end="46"/>
		</localvariabletable>
	</operation>
	<operation name="67">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="68"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="57"/>
			<call arg="69"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="66"/>
			<call arg="69"/>
			<store arg="70"/>
			<load arg="19"/>
			<push arg="59"/>
			<call arg="71"/>
			<store arg="72"/>
			<load arg="72"/>
			<dup/>
			<getasm/>
			<push arg="73"/>
			<call arg="30"/>
			<set arg="38"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="74" begin="15" end="15"/>
			<lne id="75" begin="13" end="17"/>
			<lne id="65" begin="12" end="18"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="4" name="59" begin="11" end="18"/>
			<lve slot="2" name="57" begin="3" end="18"/>
			<lve slot="3" name="66" begin="7" end="18"/>
			<lve slot="0" name="17" begin="0" end="18"/>
			<lve slot="1" name="76" begin="0" end="18"/>
		</localvariabletable>
	</operation>
</asm>
