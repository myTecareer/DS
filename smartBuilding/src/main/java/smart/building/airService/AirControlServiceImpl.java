// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: airService.proto

package smart.building.airService;

public final class AirControlServiceImpl {
  private AirControlServiceImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_smart_CurrentAirRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_smart_CurrentAirRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_smart_CurrentAirReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_smart_CurrentAirReply_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_smart_AirPuriRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_smart_AirPuriRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_smart_AirPuriReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_smart_AirPuriReply_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020airService.proto\022\005smart\"!\n\021CurrentAirR" +
      "equest\022\014\n\004item\030\001 \001(\t\"\"\n\017CurrentAirReply\022" +
      "\017\n\007message\030\001 \001(\t\"-\n\016AirPuriRequest\022\013\n\003va" +
      "l\030\001 \001(\t\022\016\n\006figure\030\002 \001(\005\"\037\n\014AirPuriReply\022" +
      "\017\n\007message\030\001 \001(\t2\236\001\n\nAirService\022F\n\016currA" +
      "irQuality\022\030.smart.CurrentAirRequest\032\026.sm" +
      "art.CurrentAirReply\"\000(\001\022H\n\024openCloseAirP" +
      "urifier\022\025.smart.AirPuriRequest\032\023.smart.A" +
      "irPuriReply\"\000(\0010\001B4\n\031smart.building.airS" +
      "erviceB\025AirControlServiceImplP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_smart_CurrentAirRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_smart_CurrentAirRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_smart_CurrentAirRequest_descriptor,
        new java.lang.String[] { "Item", });
    internal_static_smart_CurrentAirReply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_smart_CurrentAirReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_smart_CurrentAirReply_descriptor,
        new java.lang.String[] { "Message", });
    internal_static_smart_AirPuriRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_smart_AirPuriRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_smart_AirPuriRequest_descriptor,
        new java.lang.String[] { "Val", "Figure", });
    internal_static_smart_AirPuriReply_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_smart_AirPuriReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_smart_AirPuriReply_descriptor,
        new java.lang.String[] { "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
