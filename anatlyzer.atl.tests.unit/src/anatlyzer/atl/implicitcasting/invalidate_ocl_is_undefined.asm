<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm version="1.0" name="0">
	<cp>
		<constant value="invalidateoclisundefined"/>
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
		<constant value="A.__matchmodel():V"/>
		<constant value="__exec__"/>
		<constant value="model"/>
		<constant value="NTransientLinkSet;.getLinksByRule(S):QNTransientLink;"/>
		<constant value="A.__applymodel(NTransientLink;):V"/>
		<constant value="simple"/>
		<constant value="MABCD!Model;"/>
		<constant value="0"/>
		<constant value="optionalA"/>
		<constant value="7:3-7:7"/>
		<constant value="7:3-7:17"/>
		<constant value="7:3-7:22"/>
		<constant value="__matchmodel"/>
		<constant value="Model"/>
		<constant value="ABCD"/>
		<constant value="IN"/>
		<constant value="MMOF!Classifier;.allInstancesFrom(S):QJ"/>
		<constant value="J.oclIsUndefined():J"/>
		<constant value="J.not():J"/>
		<constant value="B.not():B"/>
		<constant value="33"/>
		<constant value="TransientLink"/>
		<constant value="NTransientLink;.setRule(MATL!Rule;):V"/>
		<constant value="src"/>
		<constant value="NTransientLink;.addSourceElement(SJ):V"/>
		<constant value="tgt"/>
		<constant value="WXYZ"/>
		<constant value="NTransientLink;.addTargetElement(SJ):V"/>
		<constant value="NTransientLinkSet;.addLink2(NTransientLink;B):V"/>
		<constant value="17:30-17:33"/>
		<constant value="17:30-17:43"/>
		<constant value="17:30-17:60"/>
		<constant value="17:26-17:60"/>
		<constant value="18:10-20:6"/>
		<constant value="__applymodel"/>
		<constant value="NTransientLink;"/>
		<constant value="NTransientLink;.getSourceElement(S):J"/>
		<constant value="NTransientLink;.getTargetElement(S):J"/>
		<constant value="3"/>
		<constant value="J.simple():J"/>
		<constant value="19:14-19:17"/>
		<constant value="19:14-19:26"/>
		<constant value="19:6-19:26"/>
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
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="33" begin="5" end="8"/>
			<lve slot="0" name="17" begin="0" end="9"/>
		</localvariabletable>
	</operation>
	<operation name="45">
		<context type="46"/>
		<parameters>
		</parameters>
		<code>
			<load arg="47"/>
			<get arg="48"/>
			<get arg="38"/>
		</code>
		<linenumbertable>
			<lne id="49" begin="0" end="0"/>
			<lne id="50" begin="0" end="1"/>
			<lne id="51" begin="0" end="2"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="2"/>
		</localvariabletable>
	</operation>
	<operation name="52">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="53"/>
			<push arg="54"/>
			<findme/>
			<push arg="55"/>
			<call arg="56"/>
			<iterate/>
			<store arg="19"/>
			<load arg="19"/>
			<get arg="48"/>
			<call arg="57"/>
			<call arg="58"/>
			<call arg="59"/>
			<if arg="60"/>
			<getasm/>
			<get arg="1"/>
			<push arg="61"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="42"/>
			<pcall arg="62"/>
			<dup/>
			<push arg="63"/>
			<load arg="19"/>
			<pcall arg="64"/>
			<dup/>
			<push arg="65"/>
			<push arg="53"/>
			<push arg="66"/>
			<new/>
			<pcall arg="67"/>
			<pusht/>
			<pcall arg="68"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="69" begin="7" end="7"/>
			<lne id="70" begin="7" end="8"/>
			<lne id="71" begin="7" end="9"/>
			<lne id="72" begin="7" end="10"/>
			<lne id="73" begin="25" end="30"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="63" begin="6" end="32"/>
			<lve slot="0" name="17" begin="0" end="33"/>
		</localvariabletable>
	</operation>
	<operation name="74">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="75"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="63"/>
			<call arg="76"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="65"/>
			<call arg="77"/>
			<store arg="78"/>
			<load arg="78"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<call arg="79"/>
			<call arg="30"/>
			<set arg="38"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="80" begin="11" end="11"/>
			<lne id="81" begin="11" end="12"/>
			<lne id="82" begin="9" end="14"/>
			<lne id="73" begin="8" end="15"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="65" begin="7" end="15"/>
			<lve slot="2" name="63" begin="3" end="15"/>
			<lve slot="0" name="17" begin="0" end="15"/>
			<lve slot="1" name="83" begin="0" end="15"/>
		</localvariabletable>
	</operation>
</asm>
